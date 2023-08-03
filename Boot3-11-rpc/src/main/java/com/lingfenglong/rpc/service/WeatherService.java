package com.lingfenglong.rpc.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class WeatherService {
    public Mono<String> getWeatherRealtime(String lnglat) {
        return WebClient.create()
                .get()
                .uri("http://caiyunapi.market.alicloudapi.com/realtime/" + lnglat)
                .header("Authorization","APPCODE f9fa127b9be74444b4e368504763bbb8")
                .header("X-Ca-Nonce", UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);
    }
}