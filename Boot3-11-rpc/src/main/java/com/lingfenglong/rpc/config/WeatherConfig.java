package com.lingfenglong.rpc.config;

import com.lingfenglong.rpc.service.IWeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WeatherConfig {

    @Bean
    public HttpServiceProxyFactory httpServiceProxyFactory(@Value("${aliyun.appcode}") String appcode) {
        WebClient client = WebClient.builder()
                .baseUrl("http://caiyunapi.market.alicloudapi.com")
                .defaultHeader("Authorization","APPCODE " + appcode)
                .codecs(clientCodecConfigurer -> {
                    clientCodecConfigurer
                            .defaultCodecs()
                            .maxInMemorySize(256 * 1024 * 1024);
                    //响应数据量太大有可能会超出BufferSize，所以这里设置的大一点
                }).build();

        return HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client))
                .build();
    }

    @Bean
    public IWeatherService IWeatherService(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(IWeatherService.class);
    }
}
