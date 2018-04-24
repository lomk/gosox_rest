package ua.com.gosox.domains;


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
    @Column(name = "description")
    private String description;
    @Column(name = "seo_description")
    private String seoDescription;
    @Column(name = "barcode")
    private Long barcode;
    @Column(name = "internal_code")
    private Long internalCode;
    @Column(name = "price_usd")
    private Long priceSellUsd;
    @Column(name = "price_uah")
    private Long priceSellUah;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "number_of_orders")
    private Long numberOfOrders;
    @Column(name = "is_new")
    private Boolean isNew;
    @Column(name = "image_url_1")
    private String imageUrl1;
    @Column(name = "image_url_2")
    private String imageUrl2;
    @Column(name = "image_url_3")
    private String imageUrl3;
    @Column(name = "image_url_4")
    private String imageUrl4;
    @Column(name = "image_url_5")
    private String imageUrl5;



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
    @JoinColumn(name = "product_brand_id")
    private ProductSize productSize;
    @ManyToOne
    @JoinColumn(name = "product_brand_id")
    private ProductComposition productComposition;
}
