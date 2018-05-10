package ua.com.gosox.domains;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Table(schema = "gosox", name = "ORDER_STATUS")
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
    private Float purchasePrice;
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

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
