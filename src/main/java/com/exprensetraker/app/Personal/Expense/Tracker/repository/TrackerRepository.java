package com.exprensetraker.app.Personal.Expense.Tracker.repository;

import com.exprensetraker.app.Personal.Expense.Tracker.model.TrackerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackerRepository extends JpaRepository<TrackerModel, Long> {
    List<TrackerModel> findByType(String type);
    List<TrackerModel> findByCategory(String category);
}