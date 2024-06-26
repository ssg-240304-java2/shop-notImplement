package com.ohgiraffers.notimplement.user.model.service;

public interface UserService {
    int getAvailablePoint(int userId);

    int refundPoint(int userId, int getAvailablePoint, String point);
}
