package com.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem
{
    private Long itemId;
    private String itemName;
    private int quantity;
    private Double price;
}
