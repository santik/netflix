package com.santik.eurekaclientfeign.service;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.santik.eurekaclientfeign.client.AppDataClientClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DataService {

    private final AppDataClientClient client;
    private final EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    public String getAppData() {

        Application currentApplication = eurekaClient.getApplication(appName);
        log.info("Current application {}", currentApplication);

        String string = String.format(
                "Current Application is '%s'", currentApplication.getName());
        return string + " " + client.request();
    }
}
