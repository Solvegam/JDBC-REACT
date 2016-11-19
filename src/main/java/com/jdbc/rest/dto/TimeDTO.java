package com.jdbc.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by stas on 16.11.16.
 */

@XmlRootElement
public final class TimeDTO {

    private int dayOfYear;
    private int dayOfMonth;
    private int dayOfWeek;
    private int monthOfYear;
    private int year;
    private int hours;
    private int minutes;
    private int seconds;
    private String timeZoneOffset;
    private String timeZoneId;
    private String dayOfWeekName;
    private String monthName;
    private String timeZoneName;
    private String timeZoneRules;
    private String dateTime;

    public TimeDTO () {

    }

    private TimeDTO (Builder builder) {
        this.dayOfYear = builder.dayOfYear;
        this.dayOfMonth = builder.dayOfMonth;
        this.dayOfWeek = builder.dayOfWeek;
        this.monthOfYear = builder.monthOfYear;
        this.year = builder.year;
        this.hours = builder.hours;
        this.minutes = builder.minutes;
        this.seconds = builder.seconds;
        this.timeZoneId = builder.timeZoneId;
        this.timeZoneOffset = builder.timeZoneOffset;
        this.dayOfWeekName = builder.dayOfWeekName;
        this.monthName = builder.monthName;
        this.timeZoneName = builder.timeZoneName;
        this.timeZoneRules = builder.timeZoneRules;
        this.dateTime = builder.dateTime;
    }

    public int getDayOfYear() {
        return dayOfYear;
    }

    public void setDayOfYear(int dayOfYear) {
        this.dayOfYear = dayOfYear;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getMonthOfYear() {
        return monthOfYear;
    }

    public void setMonthOfYear(int monthOfYear) {
        this.monthOfYear = monthOfYear;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String getTimeZoneOffset() {
        return timeZoneOffset;
    }

    public void setTimeZoneOffset(String timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public String getDayOfWeekName() {
        return dayOfWeekName;
    }

    public void setDayOfWeekName(String dayOfWeekName) {
        this.dayOfWeekName = dayOfWeekName;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getTimeZoneName() {
        return timeZoneName;
    }

    public void setTimeZoneName(String timeZoneName) {
        this.timeZoneName = timeZoneName;
    }

    public String getTimeZoneRules() {
        return timeZoneRules;
    }

    public void setTimeZoneRules(String timeZoneRules) {
        this.timeZoneRules = timeZoneRules;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public static final Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private int dayOfYear;
        private int dayOfMonth;
        private int dayOfWeek;
        private int monthOfYear;
        private int year;
        private int hours;
        private int minutes;
        private int seconds;
        private String timeZoneOffset;
        private String dayOfWeekName;
        private String monthName;
        private String timeZoneName;
        private String timeZoneRules;
        private String timeZoneId;
        private String dateTime;

        private Builder () {

        }

        public Builder withDayOfYear(int dayOfYear) {
            this.dayOfYear = dayOfYear;
            return this;
        }

        public Builder withDayOfMonth(int dayOfMonth) {
            this.dayOfMonth = dayOfMonth;
            return this;
        }

        public Builder withDayOfWeek(int dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
            return this;
        }

        public Builder withDayOfWeekName(String dayOfWeekName) {
            this.dayOfWeekName = dayOfWeekName;
            return this;
        }

        public Builder withMonthOfYear(int monthOfYear) {
            this.monthOfYear = monthOfYear;
            return this;
        }

        public Builder withMonthName(String monthName) {
            this.monthName = monthName;
            return this;
        }

        public Builder withYear(int year) {
            this.year = year;
            return this;
        }

        public Builder withHours(int hours) {
            this.hours = hours;
            return this;
        }

        public Builder withMinutes(int minutes) {
            this.minutes = minutes;
            return this;
        }

        public Builder withSeconds(int seconds) {
            this.seconds = seconds;
            return this;
        }

        public Builder withTimeZoneName(String timeZoneName) {
            this.timeZoneName = timeZoneName;
            return this;
        }

        public Builder withTimeZoneId(String timeZoneId) {
            this.timeZoneId = timeZoneId;
            return this;
        }

        public Builder withTimeZoneRules(String timeZoneRules) {
            this.timeZoneRules = timeZoneRules;
            return this;
        }

        public Builder withTimeZoneOffset(String timeZoneOffset) {
            this.timeZoneOffset = timeZoneOffset;
            return this;
        }

        public Builder withDateTime(String dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public TimeDTO build() {
            return new TimeDTO(this);
        }
    }
}
