package com.proton.mobilecontroller.config;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {
    private static final String BROKER_URL = "tcp://localhost:1883";
    private static final String TOPIC = "proton/MPU/+/+";

    @Bean
    public MqttClient mqttClient() throws Exception {
        MqttClient client = new MqttClient(BROKER_URL, MqttClient.generateClientId());
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        System.out.println("Attempting to connect to MQTT broker: " + BROKER_URL);
        client.connect(options);
        System.out.println("Connected to MQTT broker");
        client.subscribe(TOPIC, 0, (topic, msg) -> {
            System.out.println("Subscribed to topic: " + TOPIC);
        });
        return client;
    }
}