package com.santik.eurekaclient.controller;

import com.santik.eurekaclient.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ApplicationService service;

    @RequestMapping("/request")
    public String request() {
        return service.getData();
    }
}
