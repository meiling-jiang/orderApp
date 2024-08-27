package net.javaguides.oms.controller;

import lombok.AllArgsConstructor;
import net.javaguides.oms.dto.OrderDto;
import net.javaguides.oms.dto.ProductDto;
import net.javaguides.oms.entity.Product;
import net.javaguides.oms.service.product.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from Angular frontend
public class ProductController {
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        List<ProductDto> productDtos = products.stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(productDtos);
    }

    private ProductDto convertToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setProductName(product.getProductName());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        if (product.getImage() != null) {
            // Convert byte[] to base64 string
            String base64Image = Base64.getEncoder().encodeToString(product.getImage());
            dto.setImage("data:image/jpeg;base64," + base64Image); // Use the appropriate MIME type
        }
        return dto;
    }

    @GetMapping("/images/{productId}")
    public ResponseEntity<byte[]> getProductImage(@PathVariable Long productId) {
        // Fetch the product from the database
        Product product = productService.getProductById(productId);

        if (product == null || product.getImage() == null) {
            return ResponseEntity.notFound().build();
        }

        // Return the image as a byte array with the appropriate headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // Adjust as needed (e.g., IMAGE_PNG)
        return new ResponseEntity<>(product.getImage(), headers, HttpStatus.OK);
    }
}
