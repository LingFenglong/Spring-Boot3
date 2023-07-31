package com.lingfenglong.core.service;

import com.lingfenglong.core.entity.User;
import com.lingfenglong.core.event.LoginSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements ApplicationListener<LoginSuccessEvent> {

    @Override
    public void onApplicationEvent(LoginSuccessEvent event) {
        addAccountScore(((User) event.getSource()));
    }

    public void addAccountScore(User user) {
        System.out.println("===== " + user.getUsername() + "获得了1积分");
    }
}
