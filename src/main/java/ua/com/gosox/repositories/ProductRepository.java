package ua.com.gosox.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.*;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByProductBrand(ProductBrand productBrand, Pageable pageable);
    List<Product> findByProductBrandAndProductCategory(ProductBrand productBrand,
                                                       ProductCategory productCategory,
                                                       Pageable pageable);
    List<Product> findByProductBrandAndProductCategoryAndProductGender(ProductBrand productBrand,
                                                                       ProductCategory productCategory,
                                                                       ProductGender productGender,
                                                                       Pageable pageable);
    List<Product> findByProductBrandAndProductCategoryAndProductGenderAndProductMaterial(ProductBrand productBrand,
                                                                                         ProductCategory productCategory,
                                                                                         ProductGender productGender,
                                                                                         ProductMaterial productMaterial,
                                                                                         Pageable pageable);
    List<Product> findByProductBrandAndProductCategoryAndProductGenderAndProductMaterialAndProductSize(ProductBrand productBrand,
                                                                                                       ProductCategory productCategory,
                                                                                                       ProductGender productGender,
                                                                                                       ProductMaterial productMaterial,
                                                                                                       ProductSize productSize,
                                                                                                       Pageable pageable);
    List<Product> findByProductBrandAndProductCategoryAndProductGenderAndProductSize(ProductBrand productBrand,
                                                                                     ProductCategory productCategory,
                                                                                     ProductGender productGender,
                                                                                     ProductSize productSize,
                                                                                     Pageable pageable);

    List<Product> findByProductBrandAndProductCategoryAndProductMaterial(ProductBrand productBrand,
                                                                         ProductCategory productCategory,
                                                                         ProductMaterial productMaterial,
                                                                         Pageable pageable);
    List<Product> findByProductBrandAndProductCategoryAndProductMaterialAndProductSize(ProductBrand productBrand,
                                                                                       ProductCategory productCategory,
                                                                                       ProductMaterial productMaterial,
                                                                                       ProductSize productSize,
                                                                                       Pageable pageable);

    List<Product> findByProductBrandAndProductCategoryAndProductSize(ProductBrand productBrand,
                                                                      ProductCategory productCategory,
                                                                      ProductSize productSize,
                                                                      Pageable pageable);

    List<Product> findByProductBrandAndProductGender(ProductBrand productBrand,
                                                     ProductGender productGender,
                                                     Pageable pageable);

    List<Product> findByProductBrandAndProductGenderAndProductMaterial(ProductBrand productBrand,
                                                                       ProductGender productGender,
                                                                       ProductMaterial productMaterial,
                                                                       Pageable pageable);
    List<Product> findByProductBrandAndProductGenderAndProductMaterialAndProductSize(ProductBrand productBrand,
                                                                                     ProductGender productGender,
                                                                                     ProductMaterial productMaterial,
                                                                                     ProductSize productSize,
                                                                                     Pageable pageable);

    List<Product> findByProductBrandAndProductGenderAndProductSize(ProductBrand productBrand,
                                                                   ProductGender productGender,
                                                                   ProductSize productSize,
                                                                   Pageable pageable);

    List<Product> findByProductBrandAndProductMaterial(ProductBrand productBrand,
                                                       ProductMaterial productMaterial,
                                                       Pageable pageable);
    List<Product> findByProductBrandAndProductMaterialAndProductSize(ProductBrand productBrand,
                                                                     ProductMaterial productMaterial,
                                                                     ProductSize productSize,
                                                                     Pageable pageable);

    List<Product> findByProductBrandAndProductSize(ProductBrand productBrand,
                                                   ProductSize productSize,
                                                   Pageable pageable);


    List<Product> findByProductCategory(ProductCategory productCategory, Pageable pageable);

    List<Product> findByProductCategoryAndProductGender(ProductCategory productCategory,
                                                        ProductGender productGender,
                                                        Pageable pageable);
    List<Product> findByProductCategoryAndProductGenderAndProductMaterial(ProductCategory productCategory,
                                                                          ProductGender productGender,
                                                                          ProductMaterial productMaterial,
                                                                          Pageable pageable);
    List<Product> findByProductCategoryAndProductGenderAndProductMaterialAndProductSize(ProductCategory productCategory,
                                                                                        ProductGender productGender,
                                                                                        ProductMaterial productMaterial,
                                                                                        ProductSize productSize,
                                                                                        Pageable pageable);
    List<Product> findByProductCategoryAndProductGenderAndProductSize(ProductCategory productCategory,
                                                                      ProductGender productGender,
                                                                      ProductSize productSize,
                                                                      Pageable pageable);

    List<Product> findByProductCategoryAndProductMaterial(ProductCategory productCategory,
                                                          ProductMaterial productMaterial,
                                                          Pageable pageable);
    List<Product> findByProductCategoryAndProductMaterialAndProductSize(ProductCategory productCategory,
                                                                        ProductMaterial productMaterial,
                                                                        ProductSize productSize,
                                                                        Pageable pageable);

    List<Product> findByProductCategoryAndProductSize(ProductCategory productCategory,
                                                      ProductSize productSize,
                                                      Pageable pageable);


    List<Product> findByProductGender(ProductGender productGender, Pageable pageable);

    List<Product> findByProductGenderAndProductMaterial(ProductGender productGender,
                                                        ProductMaterial productMaterial,
                                                        Pageable pageable);

    List<Product> findByProductGenderAndProductMaterialAndProductSize(ProductGender productGender,
                                                                      ProductMaterial productMaterial,
                                                                      ProductSize productSize,
                                                                      Pageable pageable);

    List<Product> findByProductGenderAndProductSize(ProductGender productGender,
                                                    ProductSize productSize,
                                                    Pageable pageable);

    List<Product> findByProductMaterial(ProductMaterial productMaterial, Pageable pageable);

    List<Product> findByProductMaterialAndProductSize(ProductMaterial productMaterial,
                                                      ProductSize productSize,
                                                      Pageable pageable);

    List<Product> findByProductSize(ProductSize productSize, Pageable pageable);


    List<Product> findAllByProductBrandOrProductBrandOrProductCategoryOrProductGenderOrProductMaterialOrProductSize(
            ProductBrand productBrand,
            ProductCategory productCategory,
            ProductGender productGender,
            ProductMaterial productMaterial,
            ProductSize productSize,
            Pageable pageable);

}
