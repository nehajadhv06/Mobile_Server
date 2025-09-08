package com.proton.mobilecontroller.services;

import jakarta.annotation.PostConstruct;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proton.mobilecontroller.model.HistoryEntry;
import com.proton.mobilecontroller.utils.MqttMessageParser;

@Service
public class MqttService implements MqttCallback {
    @Autowired
    private MqttClient mqttClient;

    @Autowired
    private ParameterService parameterService;

    @Autowired
    private HistoryService historyService;

    @PostConstruct
    public void init() {
        mqttClient.setCallback(this); // Set callback after bean initialization
    }

    @Override
    public void connectionLost(Throwable cause) {
        // Handle reconnection logic
        System.err.println("MQTT connection lost: " + cause.getMessage());
    }
@Override
public void messageArrived(String topic, MqttMessage message) throws Exception {
    String messageStr = new String(message.getPayload());
    System.out.println("Received message on topic " + topic + ": " + messageStr);
    MqttMessageParser parser = new MqttMessageParser();
    var parameters = parser.parseMessage(messageStr);
    if (parameters.containsKey("PR")) {
        String deviceId = parameters.get("PR"); // Should be MPU24001
        parameterService.saveParameters(parameters);
        String event = parameters.containsKey("C_PUMP") ? (parameters.get("C_PUMP").equals("1") ? "Pump Started" : "Pump Stopped") : "Parameter Update";
        String details = "Received parameters for device: " + deviceId;
        historyService.saveHistory(new HistoryEntry(deviceId, event, details));
    }
}

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // Handle delivery complete
    }

    public void publish(String message) {
        try {
            MqttMessage mqttMessage = new MqttMessage(message.getBytes());
            mqttMessage.setQos(0);
            // Modified: Changed publish topic to "proton/MPU/+/td" to add proton/ prefix (note: wildcard may need adjustment if used; since frontend uses direct MQTT, this may not be called)
            mqttClient.publish("proton/MPU/+/td", mqttMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

