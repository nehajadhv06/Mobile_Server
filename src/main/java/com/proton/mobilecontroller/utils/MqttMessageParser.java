
package com.proton.mobilecontroller.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class MqttMessageParser {
    // Removed: ObjectMapper usage for initial parse, as we now parse the raw string directly

    public Map<String, String> parseMessage(String message) {
        Map<String, String> parameters = new HashMap<>();
        try {
            // Modified: Directly parse the message string assuming it's {key:value,...} format without wrapper
            String payload = message;
            if (payload.startsWith("{") && payload.endsWith("}")) {
                payload = payload.substring(1, payload.length() - 1);
                String[] pairs = payload.split(",");
                for (String pair : pairs) {
                    String[] keyValue = pair.split(":");
                    if (keyValue.length == 2) {
                        parameters.put(keyValue[0].trim(), keyValue[1].trim());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parameters;
    }
}
