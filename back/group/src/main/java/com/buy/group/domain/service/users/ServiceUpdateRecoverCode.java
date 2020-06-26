package com.buy.group.domain.service.users;

import java.util.Random;

import com.buy.group.domain.exception.GeneralException;
import com.buy.group.domain.model.User;
import com.buy.group.domain.port.RepositoryUser;

public class ServiceUpdateRecoverCode {
    private final String THE_USER_WAS_NOT_FOUND = "No existe un usuario con este correo electrónico";
    private final String TARGET_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private final int TARGET_CHARACTERS_LENGTH = TARGET_CHARACTERS.length();
    private RepositoryUser userRepository;

    public ServiceUpdateRecoverCode(RepositoryUser userRepository) {
        this.userRepository = userRepository;
    }

    public void run(String email) {
        User user = this.userRepository.getByEmail(email);
        if (user != null) {
            String newCode = "";
            Random random = new Random();
            for (int i = 0; i < 8; i++) {
                int randomNumber = random.nextInt(this.TARGET_CHARACTERS_LENGTH);
                newCode += this.TARGET_CHARACTERS.charAt(randomNumber);
            }
            this.userRepository.updateRecoverCode(user, newCode);

        } else {
            throw new GeneralException(this.THE_USER_WAS_NOT_FOUND);
        }
    }
}