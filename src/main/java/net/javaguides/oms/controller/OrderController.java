package net.javaguides.oms.controller;

import lombok.AllArgsConstructor;
import net.javaguides.oms.dto.OrderDto;
import net.javaguides.oms.entity.Order;
import net.javaguides.oms.service.order.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/orders")
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from Angular frontend
public class OrderController {

    private OrderService orderService;

    // Build Add Order Rest API
    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto){
        OrderDto savedOrder = orderService.createOrder(orderDto);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }


    // Build Get Order Rest API
    @GetMapping("{id}")
    public ResponseEntity<OrderDto> getOrderByID(@PathVariable("id") Long orderID){
        OrderDto orderDto = orderService.getOrderByID(orderID);
        return ResponseEntity.ok(orderDto);
    }

    // Build Get All Orders Rest API
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    // Build Update Order Rest API
    @PutMapping("{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable("id") Long orderID,
                                                @RequestBody OrderDto updateOrder){
        OrderDto orderDto = orderService.updateOrder(orderID, updateOrder);
        return ResponseEntity.ok(orderDto);
    }

    // Build Delete Order Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long orderID){
        orderService.deleteOrder(orderID);
        return ResponseEntity.ok("The order deleted successful.");
    }


}
