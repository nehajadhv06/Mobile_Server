package com.proton.mobilecontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proton.mobilecontroller.model.Setpoints;

public interface SetpointsRepository extends JpaRepository<Setpoints, String> {
}