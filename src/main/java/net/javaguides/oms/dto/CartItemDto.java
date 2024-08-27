package net.javaguides.oms.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaguides.oms.entity.CartItem;
import net.javaguides.oms.entity.Order;
import net.javaguides.oms.entity.Product;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {
    private Long id;
    private int quantity;
    private Long orderId;
    private Long product;

}