package com.mathsena.spotifyconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpotifyConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpotifyConsumerApplication.class, args);
    }

}
