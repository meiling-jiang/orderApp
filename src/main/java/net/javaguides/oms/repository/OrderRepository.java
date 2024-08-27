package net.javaguides.oms.repository;

import net.javaguides.oms.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
//    Order findStatus(Long id);
}
