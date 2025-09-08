package com.proton.mobilecontroller.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.proton.mobilecontroller.repositories")
public class JpaConfig {
}



