package net.javaguides.oms.mapper;

import net.javaguides.oms.dto.OrderDto;
import net.javaguides.oms.entity.Order;

public class OrderMapper {

    public static OrderDto mapToOrderDto(Order order){
        return new OrderDto(
                order.getId(),
                order.getTotalPrice(),
                order.getPurchase_date(),
                order.getPurchases()
        );
    }

    public static Order mapToOrder(OrderDto orderDto){
        return new Order(
                orderDto.getId(),
                orderDto.getTotalPrice(),
                orderDto.getPurchase_date(),
                orderDto.getPurchases()
        );
    }
}
