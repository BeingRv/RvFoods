package com.rvfoods.repository;

import com.rvfoods.model.TableInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface TableInfoRepository extends JpaRepository<TableInfo, Long> {
    Optional<TableInfo> findByTableNumberAndRestaurantId(Integer tableNumber, Long restaurantId);
}
