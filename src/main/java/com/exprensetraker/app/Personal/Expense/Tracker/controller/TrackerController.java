package com.exprensetraker.app.Personal.Expense.Tracker.controller;

import com.exprensetraker.app.Personal.Expense.Tracker.model.TrackerModel;
import com.exprensetraker.app.Personal.Expense.Tracker.service.TrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TrackerController {

    @Autowired
    private TrackerService trackerService;

    @PostMapping("/entries")
    public TrackerModel addEntry(@RequestBody TrackerModel entry) {
        return trackerService.addEntry(entry);
    }

    @GetMapping("/entries")
    public List<TrackerModel> getAllEntries() {
        return trackerService.getAllEntries();
    }

    @GetMapping("/{id}")
    public Optional<TrackerModel> getEntryById(@PathVariable Long id) {
        return trackerService.getEntryById(id);
    }

    @PutMapping("/{id}")
    public TrackerModel updateEntry(@PathVariable Long id, @RequestBody TrackerModel updatedEntry) {
        return trackerService.updateEntry(id, updatedEntry);
    }

    @DeleteMapping("/{id}")
    public String deleteEntry(@PathVariable Long id) {
        trackerService.deleteEntry(id);
        return "Entry deleted successfully!";
    }

    @GetMapping("/summary")
    public Map<String, Double> getSummary() {
        return Map.of(
                "totalIncome", trackerService.getTotalIncome(),
                "totalExpenses", trackerService.getTotalExpenses()
        );
    }
}
