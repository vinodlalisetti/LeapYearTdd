package com.tdd_demo.tdd;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeapYearController {

    @Autowired
    private LeapYearService leapYearService;

    @GetMapping("/api/leapyear")
    public ResponseEntity<String> isLeapYear(@RequestParam("year") String yearParam) {
        try {
            int year = Integer.parseInt(yearParam);
            boolean isLeap = leapYearService.isLeapYear(year);
            return new ResponseEntity<>(Boolean.toString(isLeap), HttpStatus.OK);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid year format", HttpStatus.BAD_REQUEST);
        }
    }
}

