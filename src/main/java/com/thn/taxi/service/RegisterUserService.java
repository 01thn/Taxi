package com.thn.taxi.service;

import com.thn.taxi.reporitory.RegisterUserRepository;

public class RegisterUserService {
    public static boolean registerUser(String login, String password, String name) {
        return RegisterUserRepository.registerUser(login, password, name);
    }
}
