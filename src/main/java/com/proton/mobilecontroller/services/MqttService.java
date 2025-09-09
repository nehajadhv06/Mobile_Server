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
        mqttClient.setCallback(this);
    }

    @Override
    public void connectionLost(Throwable cause) {
        System.err.println("MQTT connection lost: " + cause.getMessage());
        try {
            // Attempt to reconnect
            Thread.sleep(5000);
            mqttClient.reconnect();
        } catch (Exception e) {
            System.err.println("Failed to reconnect: " + e.getMessage());
        }
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        String messageStr = new String(message.getPayload());
        System.out.println("Received message on topic " + topic + ": " + messageStr);
        
        // Extract device ID from topic (proton/MPU/PR:MPU25001/fd)
        String[] topicParts = topic.split("/");
        String deviceId = topicParts[2]; // Should be PR:MPU25001
        
        MqttMessageParser parser = new MqttMessageParser();
        var parameters = parser.parseMessage(messageStr);
        
        if (!parameters.isEmpty()) {
            parameters.put("PR", deviceId); // Add device ID to parameters
            parameterService.saveParameters(parameters);
            
            String event = parameters.containsKey("C_PUMP") ? 
                (parameters.get("C_PUMP").equals("1") ? "Pump Started" : "Pump Stopped") : "Parameter Update";
                
            String details = "Received parameters for device: " + deviceId;
            historyService.saveHistory(new HistoryEntry(deviceId, event, details));
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // Handle delivery complete
        System.out.println("Message delivery complete");
    }

    public void publish(String deviceId, String message) {
        try {
            // Publish to device's td topic (proton/MPU/PR:MPU25001/td)
            String topic = "proton/MPU/" + deviceId + "/td";
            MqttMessage mqttMessage = new MqttMessage(message.getBytes());
            mqttMessage.setQos(0);
            mqttClient.publish(topic, mqttMessage);
            System.out.println("Published to " + topic + ": " + message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to publish message: " + e.getMessage());
        }
    }
}