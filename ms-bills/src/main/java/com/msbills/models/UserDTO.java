package com.msbills.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
@Getter
@Setter
public class UserDTO {

    private String firstName;
    private String avatar;

    public UserDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.avatar = lastName;
    }
}