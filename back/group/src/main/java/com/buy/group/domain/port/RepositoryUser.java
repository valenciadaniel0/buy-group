package com.buy.group.domain.port;

import com.buy.group.domain.model.User;

public interface RepositoryUser {
    void create(User user);
}