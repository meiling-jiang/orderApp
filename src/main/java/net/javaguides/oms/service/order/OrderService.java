package net.javaguides.oms.service.order;


import net.javaguides.oms.dto.OrderDto;

import java.util.List;

public interface OrderService {

   OrderDto createOrder(OrderDto orderDto);

   OrderDto getOrderByID(Long orderID);

   List<OrderDto> getAllOrders();

   OrderDto updateOrder(Long orderID, OrderDto updateOrder);

   void deleteOrder(Long orderID);

}
