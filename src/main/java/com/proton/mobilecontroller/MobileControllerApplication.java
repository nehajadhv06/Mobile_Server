
package com.proton.mobilecontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.proton.mobilecontroller.model") // Scan for entity classes
@EnableJpaRepositories("com.proton.mobilecontroller.repository") // Scan for repository interfaces
public class MobileControllerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MobileControllerApplication.class, args);
    }
}
