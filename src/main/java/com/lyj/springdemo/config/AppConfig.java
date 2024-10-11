package com.lyj.springdemo.config;

import com.lyj.springdemo.sample.SampleDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public SampleDTO myDTO1() {
        String[] hobbys={"잠자기","여행"};
        return new SampleDTO("손흥민",30,hobbys);
    }
    @Bean
    public SampleDTO myDTO2() {
        String[] hobbys={"등산","여행"};
        return new SampleDTO("황희찬",25,hobbys);
    }
}
