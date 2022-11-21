package com.digitalmedia.users.service;

import com.digitalmedia.users.model.dto.User;
import com.digitalmedia.users.repository.KeycloakUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeycloakUserService {

    @Autowired
    private KeycloakUserRepository keycloakUserRepository;

    public List<User> getNonAdminUsers() {
        return keycloakUserRepository.getNonAdminUsers();
    }
}
