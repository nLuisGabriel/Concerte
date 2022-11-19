package com.centersound.repositories;

import com.centersound.entities.MusicalCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicalCategoryRepository extends JpaRepository<MusicalCategory, Long> {
}