package com.simplebankworker.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.simplebankworker.repository.enuns.UserType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserVO {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @CPF
    private String CPF;

    @Email
    private String email;

    @NotBlank
    private String password;

    private UserType userType;
}
