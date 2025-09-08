package com.proton.mobilecontroller.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.proton.mobilecontroller.model.Parameters;

import java.util.Optional;

public interface ParametersRepository extends JpaRepository<Parameters, String> {
    Optional<Parameters> findByDeviceId(String deviceId);
}