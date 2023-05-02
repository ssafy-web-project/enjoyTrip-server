package com.ssafy.trip.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 파일 빈 등록
@MapperScan(basePackages = {"com.ssafy.trip.model.mapper"})
public class WebMvcConfig {

}
