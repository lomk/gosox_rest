package ua.com.gosox.domains;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(schema = "gosox", name = "PRODUCT")
@Getter
@Setter
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "order")
    private Set<OrderedProduct> orderedPruducts;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "delivery_type_id", nullable = false)
    private DeliveryType deliveryType;
}
