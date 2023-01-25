package com.example.registrationOfCustomer.controller;

import com.example.registrationOfCustomer.entity.DashboardEntity;
import com.example.registrationOfCustomer.model.DashboardModel;
import com.example.registrationOfCustomer.model.TripTypeModel;
import com.example.registrationOfCustomer.repository.DashboardRepository;
import com.example.registrationOfCustomer.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/dashboard")

public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @Autowired
    DashboardRepository dashboardRepository;


    //saving data to database
//    @PostMapping("/saveData")
//    public String save(@RequestBody DashboardModel dashboardModel) {
//        String returnMessage = this.dashboardService.saveDashBoardData(dashboardModel);
//        return returnMessage;
//    }

    //for trip type List<DashBoardModel> dashboardModel) for multiple record at same time
    @PostMapping("/saveTripType")
    public  String display(@RequestBody TripTypeModel tripTypeModel) throws Exception {
        String returnMessage= this.dashboardService.saveTripType(tripTypeModel);
        return  returnMessage;
    }




   // getting data from database
    @GetMapping("/testGetMethod")
    public  List<DashboardModel> findData(String tripType){
        List<DashboardModel> dashboardModel = this.dashboardService.fetchRecords(tripType);
         return dashboardModel;

   // public  List<DashboardEntity> findData(){
       // return  dashboardRepository.findAll();
    }

    @PutMapping("updateBasePriceAndStatus/{id}")
    public String updatePriceAndStatus(@PathVariable  Integer id, @RequestBody DashboardModel dashboardModel){
        String returnMessage = this.dashboardService.updateDetail(id,dashboardModel);
        return returnMessage;
    }

    @DeleteMapping("delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
       String returnMessage= dashboardService.deleteById(id);
       return returnMessage;
    }

}
