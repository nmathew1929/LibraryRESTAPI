package com.example.navinmathew.LibraryRESTAPI.repositories;

import com.example.navinmathew.LibraryRESTAPI.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findCategoryByCategoryname(String s);
}
