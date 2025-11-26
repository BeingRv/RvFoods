package com.rvfoods.repository;

import com.rvfoods.model.OrderMain;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface OrderMainRepository extends JpaRepository<OrderMain, Long> {
    List<OrderMain> findByStatus(String status);
}
