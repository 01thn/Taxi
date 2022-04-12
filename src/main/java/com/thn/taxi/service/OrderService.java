package com.thn.taxi.service;

import com.thn.taxi.reporitory.OrderRepository;

public class OrderService {
    public static boolean makeOrder(String login, String placeFrom, String placeTo) {
        return OrderRepository.makeOrder(login, placeFrom, placeTo);
    }
}
