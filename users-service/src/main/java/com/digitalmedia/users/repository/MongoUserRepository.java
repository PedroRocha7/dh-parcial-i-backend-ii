package com.digitalmedia.users.repository;

import com.digitalmedia.users.exceptions.UserExtraNotFoundException;
import com.digitalmedia.users.model.dto.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class MongoUserRepository implements IUserRepository{

  private IMongoUserRepository mongoUserRepository;

  public MongoUserRepository(IMongoUserRepository mongoUserRepository) {
    this.mongoUserRepository = mongoUserRepository;
  }

  @Override
  public com.digitalmedia.users.model.User validateAndGetUser(String username) {
    return  getUserExtra(username).orElseThrow(() -> new UserExtraNotFoundException(username));
  }

  @Override
  public Optional<com.digitalmedia.users.model.User> getUserExtra(String username) {
    return mongoUserRepository.findById(username);
  }

  @Override
  public com.digitalmedia.users.model.User saveUserExtra(com.digitalmedia.users.model.User user) {
    return  mongoUserRepository.save(user);
  }

  @Override
  public List<User> getNonAdminUsers() {
    return null;
  }

  @Override
  public Optional<com.digitalmedia.users.model.User> getUserByUserName(String username) {
    return mongoUserRepository.findById(username);
  }
}