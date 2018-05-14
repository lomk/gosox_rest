package ua.com.gosox.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.*;



public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findByProductBrand(ProductBrand productBrand, Pageable pageable);
    Page<Product> findByProductBrandAndProductCategory(ProductBrand productBrand,
                                                       ProductCategory productCategory,
                                                       Pageable pageable);
    Page<Product> findByProductBrandAndProductCategoryAndProductGender(ProductBrand productBrand,
                                                                       ProductCategory productCategory,
                                                                       ProductGender productGender,
                                                                       Pageable pageable);
    Page<Product> findByProductBrandAndProductCategoryAndProductGenderAndProductMaterial(ProductBrand productBrand,
                                                                                         ProductCategory productCategory,
                                                                                         ProductGender productGender,
                                                                                         ProductMaterial productMaterial,
                                                                                         Pageable pageable);
    Page<Product> findByProductBrandAndProductCategoryAndProductGenderAndProductMaterialAndProductSize(ProductBrand productBrand,
                                                                                                       ProductCategory productCategory,
                                                                                                       ProductGender productGender,
                                                                                                       ProductMaterial productMaterial,
                                                                                                       ProductSize productSize,
                                                                                                       Pageable pageable);
    Page<Product> findByProductBrandAndProductCategoryAndProductGenderAndProductSize(ProductBrand productBrand,
                                                                                     ProductCategory productCategory,
                                                                                     ProductGender productGender,
                                                                                     ProductSize productSize,
                                                                                     Pageable pageable);

    Page<Product> findByProductBrandAndProductCategoryAndProductMaterial(ProductBrand productBrand,
                                                                         ProductCategory productCategory,
                                                                         ProductMaterial productMaterial,
                                                                         Pageable pageable);
    Page<Product> findByProductBrandAndProductCategoryAndProductMaterialAndProductSize(ProductBrand productBrand,
                                                                                       ProductCategory productCategory,
                                                                                       ProductMaterial productMaterial,
                                                                                       ProductSize productSize,
                                                                                       Pageable pageable);

    Page<Product> findByProductBrandAndProductCategoryAndProductSize(ProductBrand productBrand,
                                                                      ProductCategory productCategory,
                                                                      ProductSize productSize,
                                                                      Pageable pageable);

    Page<Product> findByProductBrandAndProductGender(ProductBrand productBrand,
                                                     ProductGender productGender,
                                                     Pageable pageable);

    Page<Product> findByProductBrandAndProductGenderAndProductMaterial(ProductBrand productBrand,
                                                                       ProductGender productGender,
                                                                       ProductMaterial productMaterial,
                                                                       Pageable pageable);
    Page<Product> findByProductBrandAndProductGenderAndProductMaterialAndProductSize(ProductBrand productBrand,
                                                                                     ProductGender productGender,
                                                                                     ProductMaterial productMaterial,
                                                                                     ProductSize productSize,
                                                                                     Pageable pageable);

    Page<Product> findByProductBrandAndProductGenderAndProductSize(ProductBrand productBrand,
                                                                   ProductGender productGender,
                                                                   ProductSize productSize,
                                                                   Pageable pageable);

    Page<Product> findByProductBrandAndProductMaterial(ProductBrand productBrand,
                                                       ProductMaterial productMaterial,
                                                       Pageable pageable);
    Page<Product> findByProductBrandAndProductMaterialAndProductSize(ProductBrand productBrand,
                                                                     ProductMaterial productMaterial,
                                                                     ProductSize productSize,
                                                                     Pageable pageable);

    Page<Product> findByProductBrandAndProductSize(ProductBrand productBrand,
                                                   ProductSize productSize,
                                                   Pageable pageable);


    Page<Product> findByProductCategory(ProductCategory productCategory, Pageable pageable);

    Page<Product> findByProductCategoryAndProductGender(ProductCategory productCategory,
                                                        ProductGender productGender,
                                                        Pageable pageable);
    Page<Product> findByProductCategoryAndProductGenderAndProductMaterial(ProductCategory productCategory,
                                                                          ProductGender productGender,
                                                                          ProductMaterial productMaterial,
                                                                          Pageable pageable);
    Page<Product> findByProductCategoryAndProductGenderAndProductMaterialAndProductSize(ProductCategory productCategory,
                                                                                        ProductGender productGender,
                                                                                        ProductMaterial productMaterial,
                                                                                        ProductSize productSize,
                                                                                        Pageable pageable);
    Page<Product> findByProductCategoryAndProductGenderAndProductSize(ProductCategory productCategory,
                                                                      ProductGender productGender,
                                                                      ProductSize productSize,
                                                                      Pageable pageable);

    Page<Product> findByProductCategoryAndProductMaterial(ProductCategory productCategory,
                                                          ProductMaterial productMaterial,
                                                          Pageable pageable);
    Page<Product> findByProductCategoryAndProductMaterialAndProductSize(ProductCategory productCategory,
                                                                        ProductMaterial productMaterial,
                                                                        ProductSize productSize,
                                                                        Pageable pageable);

    Page<Product> findByProductCategoryAndProductSize(ProductCategory productCategory,
                                                      ProductSize productSize,
                                                      Pageable pageable);


    Page<Product> findByProductGender(ProductGender productGender, Pageable pageable);

    Page<Product> findByProductGenderAndProductMaterial(ProductGender productGender,
                                                        ProductMaterial productMaterial,
                                                        Pageable pageable);

    Page<Product> findByProductGenderAndProductMaterialAndProductSize(ProductGender productGender,
                                                                      ProductMaterial productMaterial,
                                                                      ProductSize productSize,
                                                                      Pageable pageable);

    Page<Product> findByProductGenderAndProductSize(ProductGender productGender,
                                                    ProductSize productSize,
                                                    Pageable pageable);

    Page<Product> findByProductMaterial(ProductMaterial productMaterial, Pageable pageable);

    Page<Product> findByProductMaterialAndProductSize(ProductMaterial productMaterial,
                                                      ProductSize productSize,
                                                      Pageable pageable);

    Page<Product> findByProductSize(ProductSize productSize, Pageable pageable);


    Page<Product> findAllByProductBrandOrProductBrandOrProductCategoryOrProductGenderOrProductMaterialOrProductSize(
            ProductBrand productBrand,
            ProductCategory productCategory,
            ProductGender productGender,
            ProductMaterial productMaterial,
            ProductSize productSize,
            Pageable pageable);

}
