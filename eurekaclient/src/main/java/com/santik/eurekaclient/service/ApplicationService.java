package com.santik.eurekaclient.service;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationService {

    private final EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    public String getData() {
        Application application = eurekaClient.getApplication(appName);
        log.info("Application {}", application);
        return String.format(
                "Application '%s' is called!", application.getName());
    }
}
