package com.example.registrationOfCustomer.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TripTypeModel {
    private List<DashboardModel > local;
    private List<DashboardModel > oneWay;
    private List<DashboardModel > roundTrip;
    private List<DashboardModel > airport;

}
