package com.buy.group.domain.service.users;

import com.buy.group.domain.exception.GeneralException;
import com.buy.group.domain.model.User;
import com.buy.group.domain.port.RepositoryUser;

public class ServiceUpdatePassword {

    private final String THE_USER_WAS_NOT_FOUND = "No existe un usuario con este correo electrónico";

    private RepositoryUser userRepository;

    public ServiceUpdatePassword(RepositoryUser userRepository) {
        this.userRepository = userRepository;
    }

    public void run(User user) {
        if (user != null) {
            this.userRepository.updatePassword(user, user.getRecoverCode());

        } else {
            throw new GeneralException(this.THE_USER_WAS_NOT_FOUND);
        }
    }

}