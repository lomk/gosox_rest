package ua.com.gosox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.gosox.domains.*;
import ua.com.gosox.errors.CustomErrorType;
import ua.com.gosox.repositories.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {

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

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<?> articleList(
            @RequestParam(value = "page", required = false) Optional<Integer> page,
            @RequestParam(value = "brand", required = false) Optional<String> brand,
            @RequestParam(value = "category", required = false) Optional<String> category,
            @RequestParam(value = "size", required = false) Optional<String> size,
            @RequestParam(value = "material", required = false) Optional<String> material,
            @RequestParam(value = "gender", required = false) Optional<String> gender
    ) {
        if (page.isPresent()
                && !brand.isPresent()
                && !category.isPresent()
                && !gender.isPresent()
                && !material.isPresent()
                && !size.isPresent()
                ) {
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "dateField"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPage = productRepository.findAll(pageable);
            List<Product> productList = productPage.getContent();

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && brand.isPresent()
                && !brand.get().toString().isEmpty()
                && !category.isPresent()
                && !gender.isPresent()
                && !material.isPresent()
                && !size.isPresent()
                ) {
            ProductBrand productBrand = productBrandRepository.findByBrandName(brand.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductBrand(productBrand, pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && brand.isPresent()
                && !brand.get().toString().isEmpty()
                && category.isPresent()
                && !category.get().toString().isEmpty()
                && !gender.isPresent()
                && !material.isPresent()
                && !size.isPresent()
                ) {
            ProductBrand productBrand = productBrandRepository.findByBrandName(brand.get());
            ProductCategory productCategory = productCategoryRepository.findByCategoryName(category.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductBrandAndProductCategory(productBrand,
                    productCategory,
                    pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }



        if (page.isPresent()
                && brand.isPresent()
                && !brand.get().toString().isEmpty()
                && category.isPresent()
                && !category.get().toString().isEmpty()
                && gender.isPresent()
                && !gender.get().toString().isEmpty()
                && !material.isPresent()
                && !size.isPresent()
                ) {
            ProductBrand productBrand = productBrandRepository.findByBrandName(brand.get());
            ProductCategory productCategory = productCategoryRepository.findByCategoryName(category.get());
            ProductGender productGender = productGenderRepository.findByGenderName(gender.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductBrandAndProductCategoryAndProductGender(productBrand,
                    productCategory,
                    productGender,
                    pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && brand.isPresent()
                && !brand.get().toString().isEmpty()
                && category.isPresent()
                && !category.get().toString().isEmpty()
                && gender.isPresent()
                && !gender.get().toString().isEmpty()
                && material.isPresent()
                && !material.get().toString().isEmpty()
                && !size.isPresent()
                ) {
            ProductBrand productBrand = productBrandRepository.findByBrandName(brand.get());
            ProductCategory productCategory = productCategoryRepository.findByCategoryName(category.get());
            ProductGender productGender = productGenderRepository.findByGenderName(gender.get());
            ProductMaterial productMaterial = productMaterialRepository.findByMaterialName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList =
                    productRepository.findByProductBrandAndProductCategoryAndProductGenderAndProductMaterial(productBrand,
                    productCategory,
                    productGender,
                    productMaterial,
                    pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && brand.isPresent()
                && !brand.get().toString().isEmpty()
                && category.isPresent()
                && !category.get().toString().isEmpty()
                && gender.isPresent()
                && !gender.get().toString().isEmpty()
                && material.isPresent()
                && !material.get().toString().isEmpty()
                && size.isPresent()
                && !size.get().toString().isEmpty()
                ) {
            ProductBrand productBrand = productBrandRepository.findByBrandName(brand.get());
            ProductCategory productCategory = productCategoryRepository.findByCategoryName(category.get());
            ProductGender productGender = productGenderRepository.findByGenderName(gender.get());
            ProductMaterial productMaterial = productMaterialRepository.findByMaterialName(material.get());
            ProductSize productSize = productSizeRepository.findBySizeName(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList =
                    productRepository.findByProductBrandAndProductCategoryAndProductGenderAndProductMaterialAndProductSize(productBrand,
                            productCategory,
                            productGender,
                            productMaterial,
                            productSize,
                            pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && brand.isPresent()
                && !brand.get().toString().isEmpty()
                && category.isPresent()
                && !category.get().toString().isEmpty()
                && gender.isPresent()
                && !gender.get().toString().isEmpty()
                && !material.isPresent()
                && size.isPresent()
                && !size.get().toString().isEmpty()
                ) {
            ProductBrand productBrand = productBrandRepository.findByBrandName(brand.get());
            ProductCategory productCategory = productCategoryRepository.findByCategoryName(category.get());
            ProductGender productGender = productGenderRepository.findByGenderName(gender.get());
            ProductSize productSize = productSizeRepository.findBySizeName(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList =
                    productRepository.findByProductBrandAndProductCategoryAndProductGenderAndProductSize(productBrand,
                            productCategory,
                            productGender,
                            productSize,
                            pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && brand.isPresent()
                && !brand.get().toString().isEmpty()
                && category.isPresent()
                && !category.get().toString().isEmpty()
                && material.isPresent()
                && !material.get().toString().isEmpty()
                && !gender.isPresent()
                && !size.isPresent()
                ) {
            ProductBrand productBrand = productBrandRepository.findByBrandName(brand.get());
            ProductCategory productCategory = productCategoryRepository.findByCategoryName(category.get());
            ProductMaterial productMaterial = productMaterialRepository.findByMaterialName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductBrandAndProductCategoryAndProductMaterial(productBrand,
                    productCategory,
                    productMaterial,
                    pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && brand.isPresent()
                && !brand.get().toString().isEmpty()
                && category.isPresent()
                && !category.get().toString().isEmpty()
                && material.isPresent()
                && !material.get().toString().isEmpty()
                && size.isPresent()
                && !size.get().toString().isEmpty()
                && !gender.isPresent()
                ) {
            ProductBrand productBrand = productBrandRepository.findByBrandName(brand.get());
            ProductCategory productCategory = productCategoryRepository.findByCategoryName(category.get());
            ProductSize productSize = productSizeRepository.findBySizeName(size.get());
            ProductMaterial productMaterial = productMaterialRepository.findByMaterialName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductBrandAndProductCategoryAndProductMaterialAndProductSize(productBrand,
                    productCategory,
                    productMaterial,
                    productSize,
                    pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && brand.isPresent()
                && !brand.get().toString().isEmpty()
                && category.isPresent()
                && !category.get().toString().isEmpty()
                && size.isPresent()
                && !size.get().toString().isEmpty()
                && !material.isPresent()
                && !gender.isPresent()
                ) {
            ProductBrand productBrand = productBrandRepository.findByBrandName(brand.get());
            ProductCategory productCategory = productCategoryRepository.findByCategoryName(category.get());
            ProductSize productSize = productSizeRepository.findBySizeName(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductBrandAndProductCategoryAndProductSize(productBrand,
                    productCategory,
                    productSize,
                    pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && brand.isPresent()
                && !brand.get().toString().isEmpty()
                && gender.isPresent()
                && !gender.get().toString().isEmpty()
                && !category.isPresent()
                && !size.isPresent()
                && !material.isPresent()
                ) {
            ProductBrand productBrand = productBrandRepository.findByBrandName(brand.get());
            ProductGender productGender = productGenderRepository.findByGenderName(gender.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductGender(productGender, pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && brand.isPresent()
                && !brand.get().toString().isEmpty()
                && !category.isPresent()
                && gender.isPresent()
                && !gender.get().toString().isEmpty()
                && material.isPresent()
                && !material.get().toString().isEmpty()
                && !size.isPresent()
                ) {
            ProductBrand productBrand = productBrandRepository.findByBrandName(brand.get());
            ProductGender productGender = productGenderRepository.findByGenderName(gender.get());
            ProductMaterial productMaterial = productMaterialRepository.findByMaterialName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList =
                    productRepository.findByProductBrandAndProductGenderAndProductMaterial(productBrand,
                            productGender,
                            productMaterial,
                            pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && brand.isPresent()
                && !brand.get().toString().isEmpty()
                && !category.isPresent()
                && gender.isPresent()
                && !gender.get().toString().isEmpty()
                && material.isPresent()
                && !material.get().toString().isEmpty()
                && size.isPresent()
                && !size.get().toString().isEmpty()
                ) {
            ProductBrand productBrand = productBrandRepository.findByBrandName(brand.get());
            ProductGender productGender = productGenderRepository.findByGenderName(gender.get());
            ProductMaterial productMaterial = productMaterialRepository.findByMaterialName(material.get());
            ProductSize productSize = productSizeRepository.findBySizeName(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList =
                    productRepository.findByProductBrandAndProductGenderAndProductMaterialAndProductSize(
                            productBrand,
                            productGender,
                            productMaterial,
                            productSize,
                            pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && brand.isPresent()
                && !brand.get().toString().isEmpty()
                && !category.isPresent()
                && !gender.isPresent()
                && material.isPresent()
                && !material.get().toString().isEmpty()
                && !size.isPresent()
                ) {
            ProductBrand productBrand = productBrandRepository.findByBrandName(brand.get());
            ProductMaterial productMaterial = productMaterialRepository.findByMaterialName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList =
                    productRepository.findByProductBrandAndProductMaterial(
                            productBrand,
                            productMaterial,
                            pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && brand.isPresent()
                && !brand.get().toString().isEmpty()
                && !category.isPresent()
                && !gender.isPresent()
                && material.isPresent()
                && !material.get().toString().isEmpty()
                && size.isPresent()
                && !size.get().toString().isEmpty()
                ) {
            ProductBrand productBrand = productBrandRepository.findByBrandName(brand.get());
            ProductMaterial productMaterial = productMaterialRepository.findByMaterialName(material.get());
            ProductSize productSize = productSizeRepository.findBySizeName(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductBrandAndProductMaterialAndProductSize(
                    productBrand,
                    productMaterial,
                    productSize,
                    pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }


        if (page.isPresent()
                && category.isPresent()
                && !category.get().toString().isEmpty()
                && !brand.isPresent()
                && !size.isPresent()
                && !material.isPresent()
                && !gender.isPresent()
                ) {
            ProductCategory productCategory = productCategoryRepository.findByCategoryName(category.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductCategory(productCategory, pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && !brand.isPresent()
                && category.isPresent()
                && !category.get().toString().isEmpty()
                && gender.isPresent()
                && !gender.get().toString().isEmpty()
                && !material.isPresent()
                && !size.isPresent()
                ) {
            ProductCategory productCategory = productCategoryRepository.findByCategoryName(category.get());
            ProductGender productGender = productGenderRepository.findByGenderName(gender.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductCategoryAndProductGender(
                    productCategory,
                    productGender,
                    pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && !brand.isPresent()
                && category.isPresent()
                && !category.get().toString().isEmpty()
                && gender.isPresent()
                && !gender.get().toString().isEmpty()
                && material.isPresent()
                && !material.get().toString().isEmpty()
                && !size.isPresent()
                ) {
            ProductCategory productCategory = productCategoryRepository.findByCategoryName(category.get());
            ProductGender productGender = productGenderRepository.findByGenderName(gender.get());
            ProductMaterial productMaterial = productMaterialRepository.findByMaterialName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductCategoryAndProductGenderAndProductMaterial(
                    productCategory,
                    productGender,
                    productMaterial,
                    pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && !brand.isPresent()
                && category.isPresent()
                && !category.get().toString().isEmpty()
                && gender.isPresent()
                && !gender.get().toString().isEmpty()
                && material.isPresent()
                && !material.get().toString().isEmpty()
                && size.isPresent()
                && !size.get().toString().isEmpty()
                ) {
            ProductCategory productCategory = productCategoryRepository.findByCategoryName(category.get());
            ProductGender productGender = productGenderRepository.findByGenderName(gender.get());
            ProductMaterial productMaterial = productMaterialRepository.findByMaterialName(material.get());
            ProductSize productSize = productSizeRepository.findBySizeName(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductCategoryAndProductGenderAndProductMaterialAndProductSize(
                    productCategory,
                    productGender,
                    productMaterial,
                    productSize,
                    pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && !brand.isPresent()
                && category.isPresent()
                && !category.get().toString().isEmpty()
                && gender.isPresent()
                && !gender.get().toString().isEmpty()
                && !material.isPresent()
                && size.isPresent()
                && !size.get().toString().isEmpty()
                ) {
            ProductCategory productCategory = productCategoryRepository.findByCategoryName(category.get());
            ProductGender productGender = productGenderRepository.findByGenderName(gender.get());
            ProductSize productSize = productSizeRepository.findBySizeName(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductCategoryAndProductGenderAndProductSize(
                    productCategory,
                    productGender,
                    productSize,
                    pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && !brand.isPresent()
                && category.isPresent()
                && !category.get().toString().isEmpty()
                && material.isPresent()
                && !material.get().toString().isEmpty()
                && !gender.isPresent()
                && !size.isPresent()
                ) {
            ProductCategory productCategory = productCategoryRepository.findByCategoryName(category.get());
            ProductMaterial productMaterial = productMaterialRepository.findByMaterialName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductCategoryAndProductMaterial(productCategory,
                    productMaterial,
                    pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && !brand.isPresent()
                && category.isPresent()
                && !category.get().toString().isEmpty()
                && material.isPresent()
                && !material.get().toString().isEmpty()
                && size.isPresent()
                && !size.get().toString().isEmpty()
                && !gender.isPresent()
                ) {
            ProductCategory productCategory = productCategoryRepository.findByCategoryName(category.get());
            ProductSize productSize = productSizeRepository.findBySizeName(size.get());
            ProductMaterial productMaterial = productMaterialRepository.findByMaterialName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductCategoryAndProductMaterialAndProductSize(
                    productCategory,
                    productMaterial,
                    productSize,
                    pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && !brand.isPresent()
                && category.isPresent()
                && !category.get().toString().isEmpty()
                && size.isPresent()
                && !size.get().toString().isEmpty()
                && !material.isPresent()
                && !gender.isPresent()
                ) {
            ProductCategory productCategory = productCategoryRepository.findByCategoryName(category.get());
            ProductSize productSize = productSizeRepository.findBySizeName(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductCategoryAndProductSize(productCategory,
                    productSize,
                    pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }


        if (page.isPresent()
                && gender.isPresent()
                && !gender.get().toString().isEmpty()
                && !brand.isPresent()
                && !category.isPresent()
                && !size.isPresent()
                && !material.isPresent()
                ) {
            ProductGender productGender = productGenderRepository.findByGenderName(gender.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductGender(productGender, pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && !brand.isPresent()
                && !category.isPresent()
                && gender.isPresent()
                && !gender.get().toString().isEmpty()
                && material.isPresent()
                && !material.get().toString().isEmpty()
                && !size.isPresent()
                ) {

            ProductGender productGender = productGenderRepository.findByGenderName(gender.get());
            ProductMaterial productMaterial = productMaterialRepository.findByMaterialName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductGenderAndProductMaterial(
                            productGender,
                            productMaterial,
                            pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && !brand.isPresent()
                && !category.isPresent()
                && gender.isPresent()
                && !gender.get().toString().isEmpty()
                && material.isPresent()
                && !material.get().toString().isEmpty()
                && size.isPresent()
                && !size.get().toString().isEmpty()
                ) {
            ProductGender productGender = productGenderRepository.findByGenderName(gender.get());
            ProductMaterial productMaterial = productMaterialRepository.findByMaterialName(material.get());
            ProductSize productSize = productSizeRepository.findBySizeName(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductGenderAndProductMaterialAndProductSize(
                            productGender,
                            productMaterial,
                            productSize,
                            pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && !brand.isPresent()
                && !category.isPresent()
                && gender.isPresent()
                && !gender.get().toString().isEmpty()
                && !material.isPresent()
                && size.isPresent()
                && !size.get().toString().isEmpty()
                ) {
            ProductGender productGender = productGenderRepository.findByGenderName(gender.get());
            ProductSize productSize = productSizeRepository.findBySizeName(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductGenderAndProductSize(
                            productGender,
                            productSize,
                            pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }


        if (page.isPresent()
                && material.isPresent()
                && !material.get().toString().isEmpty()
                && !brand.isPresent()
                && !category.isPresent()
                && !size.isPresent()
                && !gender.isPresent()
                ) {
            ProductMaterial productMaterial = productMaterialRepository.findByMaterialName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductMaterial(productMaterial, pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && !brand.isPresent()
                && !category.isPresent()
                && !gender.isPresent()
                && material.isPresent()
                && !material.get().toString().isEmpty()
                && size.isPresent()
                && !size.get().toString().isEmpty()
                ) {
            ProductMaterial productMaterial = productMaterialRepository.findByMaterialName(material.get());
            ProductSize productSize = productSizeRepository.findBySizeName(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductMaterialAndProductSize(productMaterial,
                            productSize,
                            pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        if (page.isPresent()
                && size.isPresent()
                && !size.get().toString().isEmpty()
                && !brand.isPresent()
                && !category.isPresent()
                && !material.isPresent()
                && !gender.isPresent()
                ) {
            ProductSize productSize = productSizeRepository.findBySizeName(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            List<Product> productList = productRepository.findByProductSize(productSize, pageable);

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }

        return new ResponseEntity<>(new CustomErrorType(""),
                HttpStatus.NOT_FOUND);

    }
}
