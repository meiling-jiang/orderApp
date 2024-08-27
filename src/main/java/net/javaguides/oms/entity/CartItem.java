package net.javaguides.oms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    @JsonIgnore

    @Column(name = "order_id")
    private Long orderId;

//    @ManyToOne
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
//    @JsonIgnore
    @Column(name = "product_id")
    private Long product;
}
