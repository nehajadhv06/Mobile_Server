package com.proton.mobilecontroller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proton.mobilecontroller.model.Parameters;
import com.proton.mobilecontroller.services.ParameterService;

@RestController
@RequestMapping("/api/parameters")
public class ParameterController {
    @Autowired
    private ParameterService parameterService;

    @GetMapping("/{deviceId}")
    public ResponseEntity<Parameters> getParameters(@PathVariable String deviceId) {
        // Remove "PR:" prefix if present for database lookup
        String dbDeviceId = deviceId.startsWith("PR:") ? deviceId.substring(3) : deviceId;
        Parameters parameters = parameterService.getParameters(dbDeviceId);
        if (parameters != null) {
            return ResponseEntity.ok(parameters);
        }
        return ResponseEntity.notFound().build();
    }
}