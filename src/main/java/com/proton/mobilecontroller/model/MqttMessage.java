package com.proton.mobilecontroller.model;


import java.util.HashMap;
import java.util.Map;

public class MqttMessage {
    public Map<String, String> parseMessage(String message) {
        Map<String, String> parameters = new HashMap<>();
        try {
            // Handle different message formats
            String payload = message.trim();
            
            // Remove curly braces if present
            if (payload.startsWith("{") && payload.endsWith("}")) {
                payload = payload.substring(1, payload.length() - 1);
            }
            
            // Split by commas
            String[] pairs = payload.split(",");
            for (String pair : pairs) {
                // Split by colon
                String[] keyValue = pair.split(":");
                if (keyValue.length == 2) {
                    String key = keyValue[0].trim();
                    String value = keyValue[1].trim();
                    
                    // Remove quotes if present
                    if (value.startsWith("\"") && value.endsWith("\"")) {
                        value = value.substring(1, value.length() - 1);
                    }
                    
                    parameters.put(key, value);
                }
            }
        } catch (Exception e) {
            System.err.println("Error parsing MQTT message: " + e.getMessage());
        }
        return parameters;
    }
}