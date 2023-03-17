package com.itvitae.swdn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordChange {
    private String email;
    private String oldPassword;
    private String newPassword;
}
