package com.buy.group.domain.service.users;

import com.buy.group.domain.exception.GeneralException;
import com.buy.group.domain.model.User;
import com.buy.group.domain.port.RepositoryUser;

public class ServiceRecoverPassword {
    private final String THE_USER_WAS_NOT_FOUND = "No existe un usuario con este correo electrónico";
    private final String WRONG_CODE = "El código no coincide";

    private RepositoryUser userRepository;

    public ServiceRecoverPassword(RepositoryUser userRepository) {
        this.userRepository = userRepository;
    }

    public void run(User user, String recoverCode) {
        if (user != null) {
            if (user.getRecoverCode().equals(recoverCode)) {
                this.userRepository.updatePassword(user, user.getRecoverCode());
            } else {
                throw new GeneralException(this.WRONG_CODE);
            }

        } else {
            throw new GeneralException(this.THE_USER_WAS_NOT_FOUND);
        }
    }
}