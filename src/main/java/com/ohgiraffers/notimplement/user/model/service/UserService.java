package com.ohgiraffers.notimplement.user.model.service;

public interface UserService {
    int getAvailablePoint(String userId);

    int getReturningPoint(String userId);

    int refundPoint(String userId, int getAvailablePoint, String point);

    void pointCharge(String userId, String point);
}
