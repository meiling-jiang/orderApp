package net.javaguides.oms.service.product;

import lombok.AllArgsConstructor;
import net.javaguides.oms.entity.Product;
import net.javaguides.oms.exception.ResourceNotFoundException;
import net.javaguides.oms.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
    }


}
