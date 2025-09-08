package com.proton.mobilecontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proton.mobilecontroller.model.HistoryEntry;

public interface HistoryRepository extends JpaRepository<HistoryEntry, Long> {
}