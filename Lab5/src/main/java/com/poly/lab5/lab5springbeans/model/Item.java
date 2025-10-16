package com.poly.lab5.lab5springbeans.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Item {
    Integer id;
    String name;
    double price;
    int qty = 1;
}
