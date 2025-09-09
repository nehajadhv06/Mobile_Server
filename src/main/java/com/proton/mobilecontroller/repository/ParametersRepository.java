package com.proton.mobilecontroller.repository;

import com.proton.mobilecontroller.model.Parameters;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ParametersRepository extends JpaRepository<Parameters, String> {
    Optional<Parameters> findByDeviceId(String deviceId);
}