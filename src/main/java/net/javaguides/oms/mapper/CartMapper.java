package net.javaguides.oms.mapper;

import net.javaguides.oms.dto.CartItemDto;
import net.javaguides.oms.dto.OrderDto;
import net.javaguides.oms.entity.CartItem;
import net.javaguides.oms.entity.Order;

public class CartMapper {

    public static CartItemDto mapToCartItemDao(CartItem cartItem){
        return new CartItemDto(
                cartItem.getId(),
                cartItem.getQuantity(),
                cartItem.getOrderId(),
                cartItem.getProduct()
        );
    }

    public static CartItem mapToCartItem(CartItemDto cartItemDto){
        return new CartItem(
                cartItemDto.getId(),
                cartItemDto.getQuantity(),
                cartItemDto.getOrderId(),
                cartItemDto.getProduct()
        );
    }
}
