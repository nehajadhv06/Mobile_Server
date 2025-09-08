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
        // Modified: Use "PR" instead of "SR" for deviceId
        parameters.setDeviceId(params.get("PR"));
        parameters.setC_PUMP(params.getOrDefault("C_PUMP", "0"));
        parameters.setC_VOLT(params.getOrDefault("C_VOLT", "0"));
        parameters.setC_CURR(params.getOrDefault("C_CURR", "0"));
        parameters.setC_AM_MODE(params.getOrDefault("C_AM_MODE", "0"));
        parameters.setC_CYC_TIMER_MODE(params.getOrDefault("C_CYC_TIMER_MODE", "0"));
        parameters.setC_ON_TIME(params.getOrDefault("C_ON_TIME", "0"));
        parameters.setC_OFF_TIME(params.getOrDefault("C_OFF_TIME", "0"));
        parameters.setF_UV(params.getOrDefault("F_UV", "0"));
        parameters.setF_OV(params.getOrDefault("F_OV", "0"));
        parameters.setF_SPP_RP(params.getOrDefault("F_SPP_RP", "0"));
        parameters.setF_OL(params.getOrDefault("F_OL", "0"));
        parameters.setF_UL(params.getOrDefault("F_UL", "0"));
        parameters.setS_UV(params.getOrDefault("S_UV", "240"));
        parameters.setS_OV(params.getOrDefault("S_OV", "470"));
        parameters.setS_UL(params.getOrDefault("S_UL", "2"));
        parameters.setS_OL(params.getOrDefault("S_OL", "20"));
        parameters.setS_TIMER_EN(params.getOrDefault("S_TIMER_EN", "0"));
        parameters.setS_HOUR(params.getOrDefault("S_HOUR", "1"));
        parameters.setS_MIN(params.getOrDefault("S_MIN", "0"));
        parameters.setS_CYC_TIMER(params.getOrDefault("S_CYC_TIMER", "0"));
        parameters.setS_ON_TIME(params.getOrDefault("S_ON_TIME", "020"));
        parameters.setS_OFF_TIME(params.getOrDefault("S_OFF_TIME", "060"));
        parameters.setS_DRY_RUN_RST_TIME(params.getOrDefault("S_DRY_RUN_RST_TIME", "0"));
        parameters.setS_SPP_BYPASS(params.getOrDefault("S_SPP_BYPASS", "0"));
        parameters.setS_POWER_ON_DLY(params.getOrDefault("S_POWER_ON_DLY", "10"));
        parameters.setS_IOT_TIMER(params.getOrDefault("S_IOT_TIMER", "2"));
        parametersRepository.save(parameters);
    }

    public Parameters getParameters(String deviceId) {
        return parametersRepository.findByDeviceId(deviceId).orElse(null);
    }
}
