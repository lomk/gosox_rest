package ua.com.gosox.domains;




import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(schema = "gosox", name = "CART")
@Getter
@Setter
public class Cart {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "cart")
    private Set<CartProduct> cartProducts;
}