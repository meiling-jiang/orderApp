package net.javaguides.oms.repository;

import net.javaguides.oms.entity.CartItem;
import net.javaguides.oms.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
