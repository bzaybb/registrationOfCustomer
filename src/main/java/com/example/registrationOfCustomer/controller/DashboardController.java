package com.example.registrationOfCustomer.controller;

import com.example.registrationOfCustomer.model.DashboardModel;
import com.example.registrationOfCustomer.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/dashboardController")

public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @PostMapping("/save")
    public String save(@RequestBody DashboardModel dashboardModel) {
        String returnMessage = this.dashboardService.saveData(dashboardModel);
        return returnMessage;
    }


}
