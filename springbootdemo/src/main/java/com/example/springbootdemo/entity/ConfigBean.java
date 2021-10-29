package com.example.springbootdemo.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
/**
 * TODO
 *
 * @author czq
 * @date 2021/7/22 16:00
 */
@Configuration
@PropertySource(value = "classpath:test.properties",ignoreResourceNotFound = true,encoding = "UTF-8")
@Data
public class ConfigBean {
    @Value("${com.dudu.name}")
    private String name;
    @Value("${com.dudu.want}")
    private String want;
}
