package com.tdd_demo.tdd;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
public class LeapYearService {

    public boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
