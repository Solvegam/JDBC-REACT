package com.jdbc.rest;

import com.jdbc.rest.date_time_service.DateTimeService;
import com.jdbc.rest.dto.TimeDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Created by stas on 13.11.16.
 */
@Path("/rest")
public class JdbcResource {

    private static ZonedDateTime currentTime;

    @GET
    @Path("/current-time")
    @Produces(MediaType.APPLICATION_JSON)
    public TimeDTO getCurrentTime() {
        currentTime = ZonedDateTime.now();

         TimeDTO currentTimeDto = TimeDTO.newBuilder()
                .withDayOfYear(currentTime.getDayOfYear())
                .withDayOfMonth(currentTime.getDayOfMonth())
                .withDayOfWeek(currentTime.getDayOfWeek().getValue())
                .withDayOfWeekName(currentTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()))
                .withMonthName(currentTime.getMonth().name())
                .withMonthOfYear(currentTime.getMonthValue())
                .withYear(currentTime.getYear())
                .withHours(currentTime.getHour())
                .withMinutes(currentTime.getMinute())
                .withSeconds(currentTime.getSecond())
                .withTimeZoneName(currentTime.getZone().getDisplayName(TextStyle.FULL, Locale.getDefault()))
                .withTimeZoneId(currentTime.getZone().getId())
                .withTimeZoneRules(currentTime.getZone().getRules().toString())
                .withTimeZoneOffset(currentTime.getOffset().getId())
                .withDateTime(currentTime.toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();

        return currentTimeDto;
    }

    @GET
    @Path("modified-date/{param}")
    @Produces(MediaType.TEXT_PLAIN)
    public String modifyDate(@PathParam("param") Integer value) {
        return currentTime.plus(Period.ofDays(value)).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @GET
    @Path("modified-time/{param}")
    @Produces(MediaType.TEXT_PLAIN)
    public String modifyTime(@PathParam("param") Integer value) {
        return currentTime.plus(Duration.ofHours(value)).format(DateTimeFormatter.ISO_LOCAL_TIME);
    }

    @GET
    @Path("format-date/{param}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String formatTheDate(@PathParam("param") String date) {
        return LocalDate.parse(date, DateTimeFormatter.ISO_DATE).format(DateTimeFormatter.ISO_LOCAL_TIME);
    }
}
