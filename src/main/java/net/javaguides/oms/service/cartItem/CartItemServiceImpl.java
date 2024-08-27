package net.javaguides.oms.service.cartItem;

import lombok.AllArgsConstructor;
import net.javaguides.oms.dto.CartItemDto;
import net.javaguides.oms.dto.OrderDto;
import net.javaguides.oms.entity.CartItem;
import net.javaguides.oms.entity.Order;
import net.javaguides.oms.exception.ResourceNotFoundException;
import net.javaguides.oms.mapper.CartMapper;
import net.javaguides.oms.mapper.OrderMapper;
import net.javaguides.oms.repository.CartItemRepository;
import net.javaguides.oms.repository.OrderRepository;
import net.javaguides.oms.repository.ProductRepository;
import net.javaguides.oms.service.order.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor // generates a constructor initializing all object fields
public class CartItemServiceImpl implements CartItemService {

    private CartItemRepository cartItemRepository;

    @Override
    public CartItemDto createCartItem(CartItemDto cartItemDto) {
        CartItem cartItem = CartMapper.mapToCartItem(cartItemDto);
        CartItem savedCartItem = cartItemRepository.save(cartItem);
        return CartMapper.mapToCartItemDao(savedCartItem);
    }
}
