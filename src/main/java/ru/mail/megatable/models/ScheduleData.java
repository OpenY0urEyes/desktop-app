package ru.mail.megatable.models;

import java.sql.Date;

public class ScheduleData {
    private int scheduleId;
    private String dateEvent;
    private String timeEvent;
    private int doctorId;
    private String event;



    public ScheduleData(int scheduleId, String dateEvent, String timeEvent, int doctorId, String event) {
        this.scheduleId = scheduleId;
        this.dateEvent = dateEvent;
        this.timeEvent = timeEvent;
        this.doctorId = doctorId;
        this.event = event;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getTimeEvent() {
        return timeEvent;
    }

    public void setTimeEvent(String timeEvent) {
        this.timeEvent = timeEvent;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}