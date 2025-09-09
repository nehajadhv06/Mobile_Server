package com.proton.mobilecontroller.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Parameters {
    @Id
    private String deviceId;
    private String c_Pump;
    private String c_Volt;
    private String c_Curr;
    private String c_AmMode;
    private String c_CycTimerMode;
    private String c_OnTime;
    private String c_OffTime;
    private String f_Uv;
    private String f_Ov;
    private String f_SppRp;
    private String f_Ol;
    private String f_Ul;
    private String s_Uv;
    private String s_Ov;
    private String s_Ul;
    private String s_Ol;
    private String s_TimerEn;
    private String s_Hour;
    private String s_Min;
    private String s_CycTimer;
    private String s_OnTime;
    private String s_OffTime;
    private String s_DryRunRstTime;
    private String s_SppBypass;
    private String s_PowerOnDly;
    private String s_IotTimer;

    // Getters and Setters
    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }
    public String getC_Pump() { return c_Pump; }
    public void setC_Pump(String c_Pump) { this.c_Pump = c_Pump; }
    public String getC_Volt() { return c_Volt; }
    public void setC_Volt(String c_Volt) { this.c_Volt = c_Volt; }
    public String getC_Curr() { return c_Curr; }
    public void setC_Curr(String c_Curr) { this.c_Curr = c_Curr; }
    public String getC_AmMode() { return c_AmMode; }
    public void setC_AmMode(String c_AmMode) { this.c_AmMode = c_AmMode; }
    public String getC_CycTimerMode() { return c_CycTimerMode; }
    public void setC_CycTimerMode(String c_CycTimerMode) { this.c_CycTimerMode = c_CycTimerMode; }
    public String getC_OnTime() { return c_OnTime; }
    public void setC_OnTime(String c_OnTime) { this.c_OnTime = c_OnTime; }
    public String getC_OffTime() { return c_OffTime; }
    public void setC_OffTime(String c_OffTime) { this.c_OffTime = c_OffTime; }
    public String getF_Uv() { return f_Uv; }
    public void setF_Uv(String f_Uv) { this.f_Uv = f_Uv; }
    public String getF_Ov() { return f_Ov; }
    public void setF_Ov(String f_Ov) { this.f_Ov = f_Ov; }
    public String getF_SppRp() { return f_SppRp; }
    public void setF_SppRp(String f_SppRp) { this.f_SppRp = f_SppRp; }
    public String getF_Ol() { return f_Ol; }
    public void setF_Ol(String f_Ol) { this.f_Ol = f_Ol; }
    public String getF_Ul() { return f_Ul; }
    public void setF_Ul(String f_Ul) { this.f_Ul = f_Ul; }
    public String getS_Uv() { return s_Uv; }
    public void setS_Uv(String s_Uv) { this.s_Uv = s_Uv; }
    public String getS_Ov() { return s_Ov; }
    public void setS_Ov(String s_Ov) { this.s_Ov = s_Ov; }
    public String getS_Ul() { return s_Ul; }
    public void setS_Ul(String s_Ul) { this.s_Ul = s_Ul; }
    public String getS_Ol() { return s_Ol; }
    public void setS_Ol(String s_Ol) { this.s_Ol = s_Ol; }
    public String getS_TimerEn() { return s_TimerEn; }
    public void setS_TimerEn(String s_TimerEn) { this.s_TimerEn = s_TimerEn; }
    public String getS_Hour() { return s_Hour; }
    public void setS_Hour(String s_Hour) { this.s_Hour = s_Hour; }
    public String getS_Min() { return s_Min; }
    public void setS_Min(String s_Min) { this.s_Min = s_Min; }
    public String getS_CycTimer() { return s_CycTimer; }
    public void setS_CycTimer(String s_CycTimer) { this.s_CycTimer = s_CycTimer; }
    public String getS_OnTime() { return s_OnTime; }
    public void setS_OnTime(String s_OnTime) { this.s_OnTime = s_OnTime; }
    public String getS_OffTime() { return s_OffTime; }
    public void setS_OffTime(String s_OffTime) { this.s_OffTime = s_OffTime; }
    public String getS_DryRunRstTime() { return s_DryRunRstTime; }
    public void setS_DryRunRstTime(String s_DryRunRstTime) { this.s_DryRunRstTime = s_DryRunRstTime; }
    public String getS_SppBypass() { return s_SppBypass; }
    public void setS_SppBypass(String s_SppBypass) { this.s_SppBypass = s_SppBypass; }
    public String getS_PowerOnDly() { return s_PowerOnDly; }
    public void setS_PowerOnDly(String s_PowerOnDly) { this.s_PowerOnDly = s_PowerOnDly; }
    public String getS_IotTimer() { return s_IotTimer; }
    public void setS_IotTimer(String s_IotTimer) { this.s_IotTimer = s_IotTimer; }
}