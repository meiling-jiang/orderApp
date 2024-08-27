package net.javaguides.oms.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String productName;
    private float price;
    private int quantity;
    private String image; // Base64 encoded image
}
