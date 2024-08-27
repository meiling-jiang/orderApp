package net.javaguides.oms.dto;


import lombok.*;
import net.javaguides.oms.entity.CartItem;


import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private double totalPrice;
    private Date purchase_date;
    private List<CartItem> purchases;

}