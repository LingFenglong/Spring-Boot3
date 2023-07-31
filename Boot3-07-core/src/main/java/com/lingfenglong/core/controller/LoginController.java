package com.lingfenglong.core.controller;

import com.lingfenglong.core.entity.User;
import com.lingfenglong.core.event.LoginSuccessEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController implements ApplicationEventPublisherAware {

//    private EventPublisher eventPublisher;
    private ApplicationEventPublisher eventPublisher;

    @ResponseBody
    @GetMapping("/login")
    public User login(User user) {

        // 登录成功 发布事件
        LoginSuccessEvent event = new LoginSuccessEvent(user);
        eventPublisher.publishEvent(event);

        return user;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
