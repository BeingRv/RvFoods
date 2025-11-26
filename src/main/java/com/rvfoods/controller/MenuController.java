package com.rvfoods.controller;

import com.rvfoods.model.*;
import com.rvfoods.repository.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.http.*;

@RestController
@RequestMapping("/api")
public class MenuController {
    private final CategoryRepository categoryRepo;
    private final MenuItemRepository menuItemRepo;

    public MenuController(CategoryRepository categoryRepo, MenuItemRepository menuItemRepo) {
        this.categoryRepo = categoryRepo;
        this.menuItemRepo = menuItemRepo;
    }

    // Simple endpoint: get all categories and items for a restaurant (hardcoded restaurantId=1 in demo)
    @GetMapping("/menu")
    public ResponseEntity<Map<String, Object>> getMenu(@RequestParam(required = false) Long tableId,
                                                       @RequestParam(required = false) Long restaurantId) {
        Long rid = restaurantId == null ? 1L : restaurantId;
        List<Category> categories = categoryRepo.findByRestaurantId(rid);
        Map<String, Object> resp = new HashMap<>();
        List<Map<String, Object>> cats = new ArrayList<>();
        for (Category c : categories) {
            Map<String, Object> cm = new HashMap<>();
            cm.put("category", c);
            cm.put("items", menuItemRepo.findByCategoryId(c.getId()));
            cats.add(cm);
        }
        resp.put("restaurantId", rid);
        resp.put("categories", cats);
        return ResponseEntity.ok(resp);
    }
}
