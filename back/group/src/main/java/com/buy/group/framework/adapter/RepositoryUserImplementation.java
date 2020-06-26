package com.buy.group.framework.adapter;

import java.util.ArrayList;
import java.util.List;

import com.buy.group.domain.model.User;
import com.buy.group.domain.port.RepositoryUser;
import com.buy.group.framework.adapter.mapper.MapperUser;
import com.buy.group.framework.db_repository.UserDBRepository;
import com.buy.group.framework.entity.EntityRole;
import com.buy.group.framework.entity.EntityUser;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryUserImplementation implements RepositoryUser, UserDetailsService {

    private UserDBRepository userDBRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder bcryptEncoder;
    private final String USER_WITH_EMAIL_NOT_FOUND = "No se encontró un usuario con el email: ";

    public RepositoryUserImplementation(UserDBRepository userDBRepository) {
        this.userDBRepository = userDBRepository;
        this.modelMapper = new ModelMapper();
        this.bcryptEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void save(User user) {
        EntityUser entityUser = MapperUser.modelToEntity(user);
        entityUser.encryptPassword(bcryptEncoder);
        this.userDBRepository.save(entityUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EntityUser user = this.userDBRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        List<EntityRole> roles = user.getRoles();
        for (EntityRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authorities);
    }

    @Override
    public User getByEmail(String email) {
        System.out.println(this.userDBRepository.findByEmail(email).getRoles().size());
        return this.modelMapper.map(this.userDBRepository.findByEmail(email), User.class);
    }

    @Override
    public void update(User user) {
        EntityUser entityUser = MapperUser.modelToEntity(user);
        this.userDBRepository.update(entityUser.getId(), entityUser.getActive(), entityUser.getDeviceToken(),
                entityUser.getEmail(), entityUser.getName());
    }

    @Override
    public void updatePassword(User user, String newPassword) {
        if (user == null) {
            throw new UsernameNotFoundException(this.USER_WITH_EMAIL_NOT_FOUND + user.getEmail());
        }

        EntityUser entityUser = this.userDBRepository.findByUsername(user.getEmail());
        entityUser.setPassword(newPassword);
        entityUser.encryptPassword(bcryptEncoder);

        this.userDBRepository.updatePassword(entityUser.getId(), entityUser.getPassword());
    }

    @Override
    public void updateRecoverCode(User user, String newCode) {
        if (user == null) {
            throw new UsernameNotFoundException(this.USER_WITH_EMAIL_NOT_FOUND + user.getEmail());
        }

        EntityUser entityUser = this.userDBRepository.findByUsername(user.getEmail());
        entityUser.setRecoverCode(newCode);

        this.userDBRepository.updateRecoverCode(entityUser.getId(), entityUser.getRecoverCode());
    }
}