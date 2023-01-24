package com.example.registrationOfCustomer.controller;

import com.example.registrationOfCustomer.model.DashboardModel;
import com.example.registrationOfCustomer.model.TripTypeModel;
import com.example.registrationOfCustomer.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/dashboard")

public class DashboardController {

    @Autowired
    private DashboardService dashboardService;



    //saving data to database
//    @PostMapping("/saveData")
//    public String save(@RequestBody DashboardModel dashboardModel) {
//        String returnMessage = this.dashboardService.saveDashBoardData(dashboardModel);
//        return returnMessage;
//    }

    //for trip type List<DashBoardModel> dashboardModel) for multiple record at same time
    @PostMapping("/saveTripType")
    public  String display(@RequestBody TripTypeModel tripTypeModel){
        String returnMessage= this.dashboardService.saveTripType(tripTypeModel);
        return  returnMessage;
    }




   // getting data from database
    @GetMapping("/testGetMethod")
    public  List<DashboardModel> findData(@RequestParam String tripType){
        List<DashboardModel> dashboardModel = this.dashboardService.fetchRecords(tripType);
         return dashboardModel;
    }

    @PutMapping("updateBasePriceAndStatus/{id}")
    public String updatePriceAndStatus(@PathVariable  Integer id, @RequestBody DashboardModel dashboardModel){
        String returnMessage = this.dashboardService.updateDetail(id,dashboardModel);
        return returnMessage;
    }

}
