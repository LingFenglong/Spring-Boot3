package com.lingfenglong.core.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;

public class MyListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(@NonNull ApplicationEvent event) {
        System.out.println("===== 事件到达：" + event + "=====");
    }
}
