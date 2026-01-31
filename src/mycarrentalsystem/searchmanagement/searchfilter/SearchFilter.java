package mycarrentalsystem.searchmanagement.searchfilter;

import java.time.LocalDateTime;

import mycarrentalsystem.carmanagement.cartype.CarType;

public class SearchFilter {
    public int locationId;
    private LocalDateTime bookingStart;
    private LocalDateTime bookingEnd;
    private CarType carType;
}
