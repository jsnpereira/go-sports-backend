package com.go.sports.repository;

import com.go.sports.entity.Category;
import com.go.sports.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, String> {
    public List<Category> findByEvent(Event event);
}
