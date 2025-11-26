package com.rvfoods.repository;

import com.rvfoods.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByCategoryId(Long categoryId);
}
