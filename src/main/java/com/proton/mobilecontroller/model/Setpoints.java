package com.proton.mobilecontroller.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Setpoints {
    @Id
    private String deviceId;
    private String S_UV;
    private String S_OV;
    private String S_UL;
    private String S_OL;
    private String S_TIMER_EN;
    private String S_HOUR;
    private String S_MIN;
    private String S_CYC_TIMER;
    private String S_ON_TIME;
    private String S_OFF_TIME;
    private String S_DRY_RUN_RST_TIME;
    private String S_SPP_BYPASS;
    private String S_POWER_ON_DLY;
    private String S_IOT_TIMER;

    // Getters and Setters
    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }
    public String getS_UV() { return S_UV; }
    public void setS_UV(String S_UV) { this.S_UV = S_UV; }
    public String getS_OV() { return S_OV; }
    public void setS_OV(String S_OV) { this.S_OV = S_OV; }
    public String getS_UL() { return S_UL; }
    public void setS_UL(String S_UL) { this.S_UL = S_UL; }
    public String getS_OL() { return S_OL; }
    public void setS_OL(String S_OL) { this.S_OL = S_OL; }
    public String getS_TIMER_EN() { return S_TIMER_EN; }
    public void setS_TIMER_EN(String S_TIMER_EN) { this.S_TIMER_EN = S_TIMER_EN; }
    public String getS_HOUR() { return S_HOUR; }
    public void setS_HOUR(String S_HOUR) { this.S_HOUR = S_HOUR; }
    public String getS_MIN() { return S_MIN; }
    public void setS_MIN(String S_MIN) { this.S_MIN = S_MIN; }
    public String getS_CYC_TIMER() { return S_CYC_TIMER; }
    public void setS_CYC_TIMER(String S_CYC_TIMER) { this.S_CYC_TIMER = S_CYC_TIMER; }
    public String getS_ON_TIME() { return S_ON_TIME; }
    public void setS_ON_TIME(String S_ON_TIME) { this.S_ON_TIME = S_ON_TIME; }
    public String getS_OFF_TIME() { return S_OFF_TIME; }
    public void setS_OFF_TIME(String S_OFF_TIME) { this.S_OFF_TIME = S_OFF_TIME; }
    public String getS_DRY_RUN_RST_TIME() { return S_DRY_RUN_RST_TIME; }
    public void setS_DRY_RUN_RST_TIME(String S_DRY_RUN_RST_TIME) { this.S_DRY_RUN_RST_TIME = S_DRY_RUN_RST_TIME; }
    public String getS_SPP_BYPASS() { return S_SPP_BYPASS; }
    public void setS_SPP_BYPASS(String S_SPP_BYPASS) { this.S_SPP_BYPASS = S_SPP_BYPASS; }
    public String getS_POWER_ON_DLY() { return S_POWER_ON_DLY; }
    public void setS_POWER_ON_DLY(String S_POWER_ON_DLY) { this.S_POWER_ON_DLY = S_POWER_ON_DLY; }
    public String getS_IOT_TIMER() { return S_IOT_TIMER; }
    public void setS_IOT_TIMER(String S_IOT_TIMER) { this.S_IOT_TIMER = S_IOT_TIMER; }
}

