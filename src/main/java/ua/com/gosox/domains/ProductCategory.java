package ua.com.gosox.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(schema = "gosox", name = "PRODUCT_CATEGORY")
@Getter
@Setter
public class ProductCategory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_name", unique = true)
    private String categoryName;
}
