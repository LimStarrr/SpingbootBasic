package com.basic.springboot.web.response;

import com.basic.springboot.domain.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AccountsResponse {
    String phone;
    LocalDateTime createdAt;

    public static AccountsResponse valueOf(User user) {
        AccountsResponse response = new AccountsResponse();
        response.setPhone(user.getPhone());
        response.setCreatedAt(user.getCreatedAt());

        return response;
    }
}
