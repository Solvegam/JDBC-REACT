package com.jdbc.rest.date_time_service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Created by stas on 14.11.16.
 */
public class DateTimeService {

    public ZonedDateTime getCurrentTimeByCountry(String countryName) {
        ZonedDateTime currentTime = ZonedDateTime.now();
        return currentTime;
    }
}
