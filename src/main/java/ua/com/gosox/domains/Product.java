package ua.com.gosox.domains;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "gosox", name = "PRODUCT")
@Getter
@Setter
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "short_description")
    private String shortDescription;
    @Column(name = "full_description")
    private String fullDescription;
    @Column(name = "seo_description")
    private String seoDescription;
    @Column(name = "barcode")
    private Long barcode;
    @Column(name = "internal_code")
    private Long internalCode;
    @Column(name = "price_uah")
    private Long price;
    @Column(name = "is_new")
    private Boolean isNew;
    @Column(name = "in_promoution")
    private Boolean inPromoution;
    @ManyToOne
    @JoinColumn(name = "product_brand_id")
    private ProductBrand productBrand;
    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;
    @ManyToOne
    @JoinColumn(name = "product_gender_id")
    private ProductGender productGender;
    @ManyToOne
    @JoinColumn(name = "product_size_id")
    private ProductSize productSize;
    @ManyToOne
    @JoinColumn(name = "product_material_id")
    private ProductMaterial productMaterial;

}
