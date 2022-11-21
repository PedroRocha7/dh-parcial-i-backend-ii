package com.digitalmedia.users.controller;

import com.digitalmedia.users.model.dto.User;
import com.digitalmedia.users.model.dto.UserRequest;
import com.digitalmedia.users.service.IUserService;
import com.digitalmedia.users.service.KeycloakUserService;
import com.digitalmedia.users.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

  private final IUserService userService;

  @Autowired
  private final UserServiceImpl userServiceImp;

  @Autowired
  private final KeycloakUserService keycloakUserService;

  @GetMapping("/me")
  public com.digitalmedia.users.model.User getUserExtra(Principal principal) {
    return userServiceImp.validateAndGetUserExtra(principal.getName());
  }

  @GetMapping("/admin")
  @PreAuthorize("hasAuthority('GROUP_admin')")
  public List<User> getNonAdminUsers() {
    return keycloakUserService.getNonAdminUsers();
  }

  @GetMapping("/findBy")
  public Optional<com.digitalmedia.users.model.User> getUserByUsername(@RequestParam String userName) {
    return userService.getUserByUserName(userName);
  }

  @PostMapping("/save")
  public com.digitalmedia.users.model.User saveUserExtra(@Valid @RequestBody UserRequest updateUserRequest) {
    Optional<com.digitalmedia.users.model.User> userOptional = userService.getUserExtra(updateUserRequest.getUsername());
    com.digitalmedia.users.model.User userExtra = userOptional.orElseGet(() -> new com.digitalmedia.users.model.User(updateUserRequest.getUsername()));
    userExtra.setAvatar(updateUserRequest.getAvatar());

    userExtra.setUsername(updateUserRequest.getUsername());
    return userServiceImp.saveUserExtra(userExtra);
  }
}
