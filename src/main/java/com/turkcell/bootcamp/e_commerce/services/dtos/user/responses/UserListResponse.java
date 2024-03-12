package com.turkcell.bootcamp.e_commerce.services.dtos.user.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserListResponse {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
}
