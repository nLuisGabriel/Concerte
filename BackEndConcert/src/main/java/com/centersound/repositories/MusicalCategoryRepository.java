package com.centersound.repositories;

import com.centersound.entities.MusicalCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicalCategoryRepository extends JpaRepository<MusicalCategory, Long> {
}