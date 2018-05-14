package ua.com.gosox.bootstrap;

import ua.com.gosox.domains.*;
import ua.com.gosox.repositories.*;
import ua.com.gosox.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class EntityLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserService userService;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductBrandRepository productBrandRepository;
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @Autowired
    ProductSizeRepository productSizeRepository;
    @Autowired
    ProductMaterialRepository productMaterialRepository;
    @Autowired
    ProductGenderRepository productGenderRepository;
    @Autowired
    ProductReviewRepository productReviewRepository;



    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Role role = new Role();
        role.setName("ADMIN");
        roleRepository.save(role);


        User user = new User();
        user.setUsername("admin");
        user.setPassword("Mlgame.ru");
        user.setRole(roleRepository.findByName("ADMIN"));
        userService.save(user);

        Product product = new Product();
        ProductSize productSize = new ProductSize();
        productSize.setSize("22");
        productSizeRepository.save(productSize);
        ProductMaterial productMaterial = new ProductMaterial();
        productMaterial.setName("Material");
        productMaterialRepository.save(productMaterial);
        ProductGender productGender= new ProductGender();
        productGender.setName("Name");
        productGenderRepository.save(productGender);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("Name");
        productCategoryRepository.save(productCategory);
        ProductBrand productBrand = new ProductBrand();
        productBrand.setName("Product Brand");
        productBrandRepository.save(productBrand);

        product.setBarcode(new Long(123));
        product.setFullDescription("Full description");
        product.setShortDescription("Short description");
        product.setInPromoution(true);
        product.setInternalCode(new Long(1));
        product.setIsNew(true);
        product.setName("Name");
        product.setPrice(new Long(21));
        product.setProductBrand(productBrand);
        product.setProductCategory(productCategory);
        product.setProductMaterial(productMaterial);
        product.setProductGender(productGender);
        product.setProductSize(productSize);
        productRepository.save(product);



        ProductDetails productDetails = new ProductDetails();
        productDetails.setProduct(product);
        productDetails.setNumberOfCart(new Long(1));
        productDetails.setNumberOfOrders(new Long(1));
        productDetails.setNumberOfRefusal(new Long(1));
        productDetails.setPurchasePrice(new Double(2.5));
        productDetails.setQuantityInStock(new Long(1));
        productDetails.setQuantity(new Long(1));
        productDetails.setPurchasePrice(new Double(1));


        ProductReview productReview = new ProductReview();
        productReview.setProduct(product);
    }
}

