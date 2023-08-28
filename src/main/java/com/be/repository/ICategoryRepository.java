package com.be.repository;

import com.be.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
