package ua.com.gosox.domains;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Table(schema = "gosox", name = "PRODUCT_DETAILS")
@Getter
@Setter
public class ProductDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "purchase_price")
    private Double purchasePrice;
    @Column(name = "number_of_orders")
    private Long numberOfOrders;
//    @Column(name = "number_of_views")
//    private Long numberOfViews;
    @Column(name = "number_of_cart")
    private Long numberOfCart;
    @Column(name = "number_of_refusal")
    private Long numberOfRefusal;
    @Column(name = "number_in_stock")
    private Long quantityInStock;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    private Product product;

}
