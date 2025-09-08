
package com.proton.mobilecontroller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proton.mobilecontroller.model.HistoryEntry;
import com.proton.mobilecontroller.repository.HistoryRepository;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    public Page<HistoryEntry> getHistory(Pageable pageable) {
        return historyRepository.findAll(pageable);
    }
    public void saveHistory(HistoryEntry entry) {
        historyRepository.save(entry);
    }
}
