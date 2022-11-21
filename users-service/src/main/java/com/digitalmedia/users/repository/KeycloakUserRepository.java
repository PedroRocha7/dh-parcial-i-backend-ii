package com.digitalmedia.users.repository;

import com.digitalmedia.users.model.dto.User;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class KeycloakUserRepository{

    @Autowired
    private Keycloak keycloakClient;

    @Value("${dh.keycloak.realm}")
    private String realm;

    public List<User> getNonAdminUsers(){
        List<UserRepresentation> usersFromKeycloak = keycloakClient.realm(realm).users().list();
        List<UserRepresentation> enabledUsers = usersFromKeycloak.stream().filter(userRepresentation -> {
            List<GroupRepresentation> groups = keycloakClient.realm(realm).users().get(userRepresentation.getId()).groups();
            return groups.stream().noneMatch(s -> Objects.equals(s.getName(), "admin"));
        }).collect(Collectors.toList());
        return enabledUsers.stream().map(this::toUserDTO).collect(Collectors.toList());
    }

    private User toUserDTO(UserRepresentation userRepresentation){
        return new User(userRepresentation.getUsername(), userRepresentation.getEmail());
    }
}
