package ua.com.gosox.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(schema = "gosox", name = "PRODUCT_PICTURE")
@Getter
@Setter
public class ProductPicture {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_url_1")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
