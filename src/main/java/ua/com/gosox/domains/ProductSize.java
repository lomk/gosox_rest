package ua.com.gosox.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(schema = "gosox", name = "PRODUCT_SIZE")
@Getter
@Setter
public class ProductSize {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "size_name", unique = true)
    private String sizeName;
}
