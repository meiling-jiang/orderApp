package net.javaguides.oms.service.product;

import net.javaguides.oms.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long productId);
}
