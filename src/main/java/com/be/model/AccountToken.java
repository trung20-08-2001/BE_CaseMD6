package com.be.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountToken {
    private int id;
    private String username;
    private Role role;
    private String token;
}
