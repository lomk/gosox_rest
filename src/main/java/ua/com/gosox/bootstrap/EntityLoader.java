package ua.com.gosox.bootstrap;

import ua.com.gosox.domains.*;
import ua.com.gosox.repositories.*;
import ua.com.gosox.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

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
    @Autowired
    ProductDetailsRepository productDetailsRepository;



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
        productMaterial.setName("Material_name");
        productMaterialRepository.save(productMaterial);
        ProductGender productGender= new ProductGender();
        productGender.setName("Gemder_Name");
        productGenderRepository.save(productGender);
        ProductBrand productBrand = new ProductBrand();
        productBrand.setName("Product_Brand");
        productBrandRepository.save(productBrand);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("Category_name");
        productCategoryRepository.save(productCategory);

        product.setBarcode(new Long(123));
        product.setFullDescription("Full description");
        product.setShortDescription("Short description");
        product.setInPromoution(true);
        product.setInternalCode(new Long(1));
        product.setIsNew(true);
        product.setName("ProductName");
        product.setPrice(new Long(21));
        product.setProductBrand(productBrandRepository.findByName("Product_Brand"));
        product.setProductCategory(productCategoryRepository.findByName("Category_name"));
        product.setProductMaterial(productMaterialRepository.findByName("Material_name"));
        product.setProductGender(productGenderRepository.findByName("Gemder_Name"));
        product.setProductSize(productSizeRepository.findBySize("22"));
        productRepository.save(product);


        ProductDetails productDetails = new ProductDetails();
        List<Product> plist = productRepository.findByName("ProductName");
        Product p = plist.get(0);
        System.out.println("P-name: " + p.getName());


        productDetails.setProduct(p);
        productDetails.setNumberOfCart(new Long(1));
        productDetails.setNumberOfOrders(new Long(1));
        productDetails.setNumberOfRefusal(new Long(1));
        productDetails.setPurchasePrice(new Double(2.5));
        productDetails.setQuantityInStock(new Long(1));
        productDetails.setQuantity(new Long(1));
        productDetails.setPurchasePrice(new Double(1));

        productDetailsRepository.save(productDetails);


        ProductReview productReview = new ProductReview();
        productReview.setProduct(product);
        productReview.setUser(user);
        productReviewRepository.save(productReview);


    }
}

