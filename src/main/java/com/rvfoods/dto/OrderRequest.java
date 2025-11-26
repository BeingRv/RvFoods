package com.rvfoods.dto;

import lombok.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Long tableId;
    private List<OrderLine> items;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderLine {
        private Long itemId;
        private Integer quantity;
    }
}
