package com.exprensetraker.app.Personal.Expense.Tracker.service;


import com.exprensetraker.app.Personal.Expense.Tracker.model.TrackerModel;
import com.exprensetraker.app.Personal.Expense.Tracker.repository.TrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackerService {

    @Autowired
    private TrackerRepository trackerRepository;

    public TrackerModel addEntry(TrackerModel entry) {
        return trackerRepository.save(entry);
    }

    public List<TrackerModel> getAllEntries() {
        return trackerRepository.findAll();
    }

    public Optional<TrackerModel> getEntryById(Long id) {
        return trackerRepository.findById(id);
    }

    public TrackerModel updateEntry(Long id, TrackerModel updatedEntry) {
        return trackerRepository.findById(id).map(existingEntry -> {
            existingEntry.setAmount(updatedEntry.getAmount());
            existingEntry.setCategory(updatedEntry.getCategory());
            existingEntry.setDate(updatedEntry.getDate());
            existingEntry.setDescription(updatedEntry.getDescription());
            existingEntry.setType(updatedEntry.getType());
            return trackerRepository.save(existingEntry);
        }).orElseThrow(() -> new RuntimeException("Entry not found"));
    }

    public void deleteEntry(Long id) {
        trackerRepository.deleteById(id);
    }

    public double getTotalIncome() {
        return trackerRepository.findByType("income").stream().mapToDouble(TrackerModel::getAmount).sum();
    }

    public double getTotalExpenses() {
        return trackerRepository.findByType("expense").stream().mapToDouble(TrackerModel::getAmount).sum();
    }
}
