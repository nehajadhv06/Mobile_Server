package com.proton.mobilecontroller.controllers;

import com.proton.mobilecontroller.services.MqttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private MqttService mqttService;

    @PostMapping("/send/{deviceId}")
    public ResponseEntity<String> sendMessage(@PathVariable String deviceId, @RequestBody String message) {
        try {
            mqttService.publish(deviceId, message);
            return ResponseEntity.ok("Message sent successfully to " + deviceId);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to send message: " + e.getMessage());
        }
    }
    
    @PostMapping("/setpoints/{deviceId}")
    public ResponseEntity<String> sendSetpoints(@PathVariable String deviceId, @RequestBody String setpoints) {
        try {
            // Format: {PR:MPU25001,S_UV:240,S_OV:470,...}
            String message = "{" + setpoints + "}";
            mqttService.publish(deviceId, message);
            return ResponseEntity.ok("Setpoints sent successfully to " + deviceId);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to send setpoints: " + e.getMessage());
        }
    }
    
    @PostMapping("/command/{deviceId}/{command}")
    public ResponseEntity<String> sendCommand(@PathVariable String deviceId, @PathVariable String command) {
        try {
            String message = "{" + command + "}";
            mqttService.publish(deviceId, message);
            return ResponseEntity.ok("Command sent successfully: " + message);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to send command: " + e.getMessage());
        }
    }
}