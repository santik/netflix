package com.santik.eurekaclientfeign.controller;

import com.santik.eurekaclientfeign.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class DataController {

    private final DataService service;

    @RequestMapping("/get-appdata")
    public String greeting(Model model) {
        model.addAttribute("appdata", service.getAppData());
        return "appdata-view";
    }
}
