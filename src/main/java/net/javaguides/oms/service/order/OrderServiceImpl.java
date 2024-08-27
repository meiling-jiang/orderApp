package net.javaguides.oms.service.order;

import lombok.AllArgsConstructor;
import net.javaguides.oms.dto.OrderDto;
import net.javaguides.oms.entity.CartItem;
import net.javaguides.oms.entity.Order;
import net.javaguides.oms.exception.ResourceNotFoundException;
import net.javaguides.oms.mapper.CartMapper;
import net.javaguides.oms.mapper.OrderMapper;
import net.javaguides.oms.repository.CartItemRepository;
import net.javaguides.oms.repository.OrderRepository;
import net.javaguides.oms.repository.ProductRepository;
import net.javaguides.oms.service.cartItem.CartItemService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor // generates a constructor initializing all object fields
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    private CartItemService cartItemService;
    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = OrderMapper.mapToOrder(orderDto);
        Order savedOrder = orderRepository.save(order);
        List<CartItem> purchase = order.getPurchases();
        purchase.forEach(cartItem -> {
            cartItem.setOrderId(savedOrder.getId());
            cartItemService.createCartItem(CartMapper.mapToCartItemDao(cartItem));
        });
        return OrderMapper.mapToOrderDto(savedOrder);
    }

    @Override
    public OrderDto getOrderByID(Long orderID) {
        Order order = orderRepository.findById(orderID)
                .orElseThrow(() -> new ResourceNotFoundException("Order is not exists with given id: " + orderID));
        return OrderMapper.mapToOrderDto(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map((order) -> OrderMapper.mapToOrderDto(order)).collect(Collectors.toList());
    }

    @Override
    public OrderDto updateOrder(Long orderID, OrderDto updateOrder) {

        Order order = orderRepository.findById(orderID).orElseThrow(
                () -> new ResourceNotFoundException("Order is not exists with given id: " + orderID));

//        order.setProductName(updateOrder.getProductName());
        order.setTotalPrice(updateOrder.getTotalPrice());
//        order.setQuantity(updateOrder.getQuantity());

        Order updateOrderObj = orderRepository.save(order);
        return OrderMapper.mapToOrderDto(updateOrderObj);
    }

    @Override
    public void deleteOrder(Long orderID) {
        Order order = orderRepository.findById(orderID).orElseThrow(
                () -> new ResourceNotFoundException("Order is not exists with given id: " + orderID));

        orderRepository.deleteById(orderID);
    }

}
