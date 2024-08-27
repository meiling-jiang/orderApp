package net.javaguides.oms.mapper;

import net.javaguides.oms.dto.ProductDto;
import net.javaguides.oms.entity.Product;

import java.util.Base64;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product){
//        return new ProductDto(
//                product.getId(),
//                product.getProductName(),
//                product.getPrice(),
//                product.getQuantity(),
//                product.getImage()
//        );
        ProductDto dto = new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getPrice(),
                product.getQuantity(),
                null  // Placeholder for image
        );

        if (product.getImage() != null) {
            // Convert byte[] to Base64 string
            String base64Image = Base64.getEncoder().encodeToString(product.getImage());
            dto.setImage("data:image/jpeg;base64," + base64Image); // Use the appropriate MIME type
        }

        return dto;
    }

    public static Product mapToProduct(ProductDto productDto) {
//        return new Product(
//                productDto.getId(),
//                productDto.getProductName(),
//                productDto.getPrice(),
//                productDto.getQuantity(),
//                productDto.getImage()
//        );
        Product product = new Product(
                productDto.getId(),
                productDto.getProductName(),
                productDto.getPrice(),
                productDto.getQuantity(),
                null  // Placeholder for image
        );

        if (productDto.getImage() != null) {
            // Convert Base64 string to byte[]
            String base64Image = productDto.getImage().split(",")[1];
            byte[] decodedImage = Base64.getDecoder().decode(base64Image);
            product.setImage(decodedImage);
        }

        return product;
    }
}
