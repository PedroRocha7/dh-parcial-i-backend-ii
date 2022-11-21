package com.digitalmedia.users.repository;

import com.digitalmedia.users.model.dto.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

  com.digitalmedia.users.model.User validateAndGetUser(String username);

  Optional<com.digitalmedia.users.model.User> getUserExtra(String username);

  com.digitalmedia.users.model.User saveUserExtra(com.digitalmedia.users.model.User userExtra);

  List<User> getNonAdminUsers();

  Optional<com.digitalmedia.users.model.User> getUserByUserName(String username);
}
