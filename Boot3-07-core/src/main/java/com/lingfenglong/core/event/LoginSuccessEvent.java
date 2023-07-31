package com.lingfenglong.core.event;

import com.lingfenglong.core.entity.User;
import org.springframework.context.ApplicationEvent;

public class LoginSuccessEvent extends ApplicationEvent {
    public LoginSuccessEvent(User source) {
        super(source);
    }
}
