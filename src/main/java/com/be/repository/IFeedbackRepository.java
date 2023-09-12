package com.be.repository;

import com.be.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {
}
