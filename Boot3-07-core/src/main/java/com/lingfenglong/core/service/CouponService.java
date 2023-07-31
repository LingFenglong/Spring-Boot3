package com.lingfenglong.core.service;

import com.lingfenglong.core.entity.User;
import com.lingfenglong.core.event.LoginSuccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
    @EventListener
    public void onEvent(LoginSuccessEvent event) {
        sendCoupon((User) event.getSource());
    }

    public void sendCoupon(User user) {
        System.out.println("===== " + user.getUsername() + "获得了1张优惠券");
    }
}
