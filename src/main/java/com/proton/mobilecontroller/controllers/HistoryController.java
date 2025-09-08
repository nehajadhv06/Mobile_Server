package com.proton.mobilecontroller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proton.mobilecontroller.model.HistoryEntry;
import com.proton.mobilecontroller.services.HistoryService;

@RestController
@RequestMapping("/api/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @GetMapping
    public ResponseEntity<Page<HistoryEntry>> getHistory(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(historyService.getHistory(pageable));
    }
}

