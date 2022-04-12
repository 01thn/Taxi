package com.thn.taxi.service;

import com.thn.taxi.reporitory.CheckUserRepository;

public class CheckUserService {
    public static boolean checkUser(String login, String password) {
        return CheckUserRepository.checkUser(login, password);
    }
}
