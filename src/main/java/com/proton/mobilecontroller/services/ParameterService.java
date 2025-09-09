package com.proton.mobilecontroller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proton.mobilecontroller.model.Parameters;
import com.proton.mobilecontroller.repository.ParametersRepository;

import java.util.Map;

@Service
public class ParameterService {
    @Autowired
    private ParametersRepository parametersRepository;

    public void saveParameters(Map<String, String> params) {
        Parameters parameters = new Parameters();
        // Modified: Use "PR" for deviceId, consistent with input
        parameters.setDeviceId(params.get("PR"));
        parameters.setC_Pump(params.getOrDefault("C_PUMP", "0"));
        parameters.setC_Volt(params.getOrDefault("C_VOLT", "0"));
        parameters.setC_Curr(params.getOrDefault("C_CURR", "0"));
        parameters.setC_AmMode(params.getOrDefault("C_AM_MODE", "0"));
        parameters.setC_CycTimerMode(params.getOrDefault("C_CYC_TIMER_MODE", "0"));
        parameters.setC_OnTime(params.getOrDefault("C_ON_TIME", "0"));
        parameters.setC_OffTime(params.getOrDefault("C_OFF_TIME", "0"));
        parameters.setF_Uv(params.getOrDefault("F_UV", "0"));
        parameters.setF_Ov(params.getOrDefault("F_OV", "0"));
        parameters.setF_SppRp(params.getOrDefault("F_SPP_RP", "0"));
        parameters.setF_Ol(params.getOrDefault("F_OL", "0"));
        parameters.setF_Ul(params.getOrDefault("F_UL", "0"));
        parameters.setS_Uv(params.getOrDefault("S_UV", "240"));
        parameters.setS_Ov(params.getOrDefault("S_OV", "470"));
        parameters.setS_Ul(params.getOrDefault("S_UL", "2"));
        parameters.setS_Ol(params.getOrDefault("S_OL", "20"));
        parameters.setS_TimerEn(params.getOrDefault("S_TIMER_EN", "0"));
        parameters.setS_Hour(params.getOrDefault("S_HOUR", "1"));
        parameters.setS_Min(params.getOrDefault("S_MIN", "0"));
        parameters.setS_CycTimer(params.getOrDefault("S_CYC_TIMER", "0"));
        parameters.setS_OnTime(params.getOrDefault("S_ON_TIME", "020"));
        parameters.setS_OffTime(params.getOrDefault("S_OFF_TIME", "060"));
        parameters.setS_DryRunRstTime(params.getOrDefault("S_DRY_RUN_RST_TIME", "0"));
        parameters.setS_SppBypass(params.getOrDefault("S_SPP_BYPASS", "0"));
        parameters.setS_PowerOnDly(params.getOrDefault("S_POWER_ON_DLY", "10"));
        parameters.setS_IotTimer(params.getOrDefault("S_IOT_TIMER", "2"));
        parametersRepository.save(parameters);
    }

    public Parameters getParameters(String deviceId) {
        return parametersRepository.findByDeviceId(deviceId).orElse(null);
    }
}