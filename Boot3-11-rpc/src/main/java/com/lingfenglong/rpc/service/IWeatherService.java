package com.lingfenglong.rpc.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface IWeatherService {

    @GetExchange(url = "/realtime/{lnglat}", accept = "application/json")
    Mono<String> getWeatherRealtime(@PathVariable("lnglat") String lnglat,
                                    @RequestHeader(name = "X-Ca-Nonce") String xCaNonce);
    @GetExchange(url = "/forecast/15d/{lnglat}", accept = "application/json")
    Mono<String> getWeatherForecast15d(@PathVariable("lnglat") String lnglat,
                                    @RequestHeader(name = "X-Ca-Nonce") String xCaNonce);

    @GetExchange(url = "/forecast/24hour/{lnglat}", accept = "application/json")
    Mono<String> getWeatherForecast24h(@PathVariable("lnglat") String lnglat,
                                    @RequestHeader(name = "X-Ca-Nonce") String xCaNonce);
}
