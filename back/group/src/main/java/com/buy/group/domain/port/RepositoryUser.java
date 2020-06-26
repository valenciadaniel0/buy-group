package com.buy.group.domain.port;

import com.buy.group.domain.model.User;

public interface RepositoryUser {
    void save(User user);

    User getByEmail(String email);

    void update(User user);

    void updatePassword(User user, String newPassword);

    void updateRecoverCode(User user, String newCode);
}