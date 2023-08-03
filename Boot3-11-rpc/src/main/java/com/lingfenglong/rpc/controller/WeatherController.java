package com.lingfenglong.rpc.controller;

import com.lingfenglong.rpc.service.IWeatherService;
import com.lingfenglong.rpc.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class WeatherController {
    private final WeatherService weatherService;
    private final IWeatherService iWeatherService;

    @Autowired
    public WeatherController(WeatherService weatherService, IWeatherService iWeatherService) {
        this.weatherService = weatherService;
        this.iWeatherService = iWeatherService;
    }

    @GetMapping("/weather/realtime/{lnglat}")
    public Mono<String> getWeatherRealtime(@PathVariable("lnglat") String lnglat) {
        return iWeatherService.getWeatherRealtime(lnglat, UUID.randomUUID().toString());
    }

    @GetMapping("/weather/forecast/15d/{lnglat}")
    public Mono<String> getWeatherForecast15d(@PathVariable("lnglat") String lnglat) {
        return iWeatherService.getWeatherForecast15d(lnglat, UUID.randomUUID().toString());
    }

    @GetMapping("/weather/forecast/24h/{lnglat}")
    public Mono<String> getWeatherForecast24h(@PathVariable("lnglat") String lnglat) {
        return iWeatherService.getWeatherForecast24h(lnglat, UUID.randomUUID().toString());
    }
}