package ua.com.gosox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
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


    @RequestMapping(value = "top", method = RequestMethod.GET)
    public ResponseEntity<?> listTopProducts() {
        List<Product> products = productRepository.findTop10ByInPromoution(true);

        if (products == null){
            return new ResponseEntity(new CustomErrorType("No data found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<?> articleList(
            @RequestParam(value = "page", required = false) Optional<Integer> page,
            @RequestParam(value = "brand", required = false) Optional<String> brand,
            @RequestParam(value = "category", required = false) Optional<String> category,
            @RequestParam(value = "size", required = false) Optional<String> size,
            @RequestParam(value = "material", required = false) Optional<String> material,
            @RequestParam(value = "gender", required = false) Optional<String> gender
    ) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Pages", String.valueOf(1));

        if (page.isPresent()
                && !brand.isPresent()
                && !category.isPresent()
                && !gender.isPresent()
                && !material.isPresent()
                && !size.isPresent()
                ) {
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "name"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findAll(pageable);
            List<Product> productList = productPages.getContent();

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
        }

        if (page.isPresent()
                && brand.isPresent()
                && !brand.get().toString().isEmpty()
                && !category.isPresent()
                && !gender.isPresent()
                && !material.isPresent()
                && !size.isPresent()
                ) {
            ProductBrand productBrand = productBrandRepository.findByName(brand.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductBrand(productBrand, pageable);
            List<Product> productList = productPages.getContent();

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductBrand productBrand = productBrandRepository.findByName(brand.get());
            ProductCategory productCategory = productCategoryRepository.findByName(category.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductBrandAndProductCategory(productBrand,
                    productCategory,
                    pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductBrand productBrand = productBrandRepository.findByName(brand.get());
            ProductCategory productCategory = productCategoryRepository.findByName(category.get());
            ProductGender productGender = productGenderRepository.findByName(gender.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductBrandAndProductCategoryAndProductGender(productBrand,
                    productCategory,
                    productGender,
                    pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductBrand productBrand = productBrandRepository.findByName(brand.get());
            ProductCategory productCategory = productCategoryRepository.findByName(category.get());
            ProductGender productGender = productGenderRepository.findByName(gender.get());
            ProductMaterial productMaterial = productMaterialRepository.findByName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages =
                    productRepository.findByProductBrandAndProductCategoryAndProductGenderAndProductMaterial(productBrand,
                    productCategory,
                    productGender,
                    productMaterial,
                    pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductBrand productBrand = productBrandRepository.findByName(brand.get());
            ProductCategory productCategory = productCategoryRepository.findByName(category.get());
            ProductGender productGender = productGenderRepository.findByName(gender.get());
            ProductMaterial productMaterial = productMaterialRepository.findByName(material.get());
            ProductSize productSize = productSizeRepository.findBySize(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages =
                    productRepository.findByProductBrandAndProductCategoryAndProductGenderAndProductMaterialAndProductSize(productBrand,
                            productCategory,
                            productGender,
                            productMaterial,
                            productSize,
                            pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductBrand productBrand = productBrandRepository.findByName(brand.get());
            ProductCategory productCategory = productCategoryRepository.findByName(category.get());
            ProductGender productGender = productGenderRepository.findByName(gender.get());
            ProductSize productSize = productSizeRepository.findBySize(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages =
                    productRepository.findByProductBrandAndProductCategoryAndProductGenderAndProductSize(productBrand,
                            productCategory,
                            productGender,
                            productSize,
                            pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductBrand productBrand = productBrandRepository.findByName(brand.get());
            ProductCategory productCategory = productCategoryRepository.findByName(category.get());
            ProductMaterial productMaterial = productMaterialRepository.findByName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductBrandAndProductCategoryAndProductMaterial(productBrand,
                    productCategory,
                    productMaterial,
                    pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductBrand productBrand = productBrandRepository.findByName(brand.get());
            ProductCategory productCategory = productCategoryRepository.findByName(category.get());
            ProductSize productSize = productSizeRepository.findBySize(size.get());
            ProductMaterial productMaterial = productMaterialRepository.findByName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductBrandAndProductCategoryAndProductMaterialAndProductSize(productBrand,
                    productCategory,
                    productMaterial,
                    productSize,
                    pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductBrand productBrand = productBrandRepository.findByName(brand.get());
            ProductCategory productCategory = productCategoryRepository.findByName(category.get());
            ProductSize productSize = productSizeRepository.findBySize(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductBrandAndProductCategoryAndProductSize(productBrand,
                    productCategory,
                    productSize,
                    pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductBrand productBrand = productBrandRepository.findByName(brand.get());
            ProductGender productGender = productGenderRepository.findByName(gender.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);

            Page<Product> productPages = productRepository.findByProductGender(productGender, pageable);

            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductBrand productBrand = productBrandRepository.findByName(brand.get());
            ProductGender productGender = productGenderRepository.findByName(gender.get());
            ProductMaterial productMaterial = productMaterialRepository.findByName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages =
                    productRepository.findByProductBrandAndProductGenderAndProductMaterial(productBrand,
                            productGender,
                            productMaterial,
                            pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductBrand productBrand = productBrandRepository.findByName(brand.get());
            ProductGender productGender = productGenderRepository.findByName(gender.get());
            ProductMaterial productMaterial = productMaterialRepository.findByName(material.get());
            ProductSize productSize = productSizeRepository.findBySize(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages =
                    productRepository.findByProductBrandAndProductGenderAndProductMaterialAndProductSize(
                            productBrand,
                            productGender,
                            productMaterial,
                            productSize,
                            pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductBrand productBrand = productBrandRepository.findByName(brand.get());
            ProductMaterial productMaterial = productMaterialRepository.findByName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages =
                    productRepository.findByProductBrandAndProductMaterial(
                            productBrand,
                            productMaterial,
                            pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductBrand productBrand = productBrandRepository.findByName(brand.get());
            ProductMaterial productMaterial = productMaterialRepository.findByName(material.get());
            ProductSize productSize = productSizeRepository.findBySize(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductBrandAndProductMaterialAndProductSize(
                    productBrand,
                    productMaterial,
                    productSize,
                    pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
        }


        if (page.isPresent()
                && category.isPresent()
                && !category.get().toString().isEmpty()
                && !brand.isPresent()
                && !size.isPresent()
                && !material.isPresent()
                && !gender.isPresent()
                ) {
            ProductCategory productCategory = productCategoryRepository.findByName(category.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductCategory(productCategory, pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductCategory productCategory = productCategoryRepository.findByName(category.get());
            ProductGender productGender = productGenderRepository.findByName(gender.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductCategoryAndProductGender(
                    productCategory,
                    productGender,
                    pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductCategory productCategory = productCategoryRepository.findByName(category.get());
            ProductGender productGender = productGenderRepository.findByName(gender.get());
            ProductMaterial productMaterial = productMaterialRepository.findByName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductCategoryAndProductGenderAndProductMaterial(
                    productCategory,
                    productGender,
                    productMaterial,
                    pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductCategory productCategory = productCategoryRepository.findByName(category.get());
            ProductGender productGender = productGenderRepository.findByName(gender.get());
            ProductMaterial productMaterial = productMaterialRepository.findByName(material.get());
            ProductSize productSize = productSizeRepository.findBySize(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductCategoryAndProductGenderAndProductMaterialAndProductSize(
                    productCategory,
                    productGender,
                    productMaterial,
                    productSize,
                    pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductCategory productCategory = productCategoryRepository.findByName(category.get());
            ProductGender productGender = productGenderRepository.findByName(gender.get());
            ProductSize productSize = productSizeRepository.findBySize(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductCategoryAndProductGenderAndProductSize(
                    productCategory,
                    productGender,
                    productSize,
                    pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductCategory productCategory = productCategoryRepository.findByName(category.get());
            ProductMaterial productMaterial = productMaterialRepository.findByName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductCategoryAndProductMaterial(productCategory,
                    productMaterial,
                    pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductCategory productCategory = productCategoryRepository.findByName(category.get());
            ProductSize productSize = productSizeRepository.findBySize(size.get());
            ProductMaterial productMaterial = productMaterialRepository.findByName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductCategoryAndProductMaterialAndProductSize(
                    productCategory,
                    productMaterial,
                    productSize,
                    pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductCategory productCategory = productCategoryRepository.findByName(category.get());
            ProductSize productSize = productSizeRepository.findBySize(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductCategoryAndProductSize(productCategory,
                    productSize,
                    pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
        }


        if (page.isPresent()
                && gender.isPresent()
                && !gender.get().toString().isEmpty()
                && !brand.isPresent()
                && !category.isPresent()
                && !size.isPresent()
                && !material.isPresent()
                ) {
            ProductGender productGender = productGenderRepository.findByName(gender.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductGender(productGender, pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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

            ProductGender productGender = productGenderRepository.findByName(gender.get());
            ProductMaterial productMaterial = productMaterialRepository.findByName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductGenderAndProductMaterial(
                            productGender,
                            productMaterial,
                            pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductGender productGender = productGenderRepository.findByName(gender.get());
            ProductMaterial productMaterial = productMaterialRepository.findByName(material.get());
            ProductSize productSize = productSizeRepository.findBySize(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductGenderAndProductMaterialAndProductSize(
                            productGender,
                            productMaterial,
                            productSize,
                            pageable);

            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductGender productGender = productGenderRepository.findByName(gender.get());
            ProductSize productSize = productSizeRepository.findBySize(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductGenderAndProductSize(
                            productGender,
                            productSize,
                            pageable);

            List<Product> productList = productPages.getContent();

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
        }


        if (page.isPresent()
                && material.isPresent()
                && !material.get().toString().isEmpty()
                && !brand.isPresent()
                && !category.isPresent()
                && !size.isPresent()
                && !gender.isPresent()
                ) {
            ProductMaterial productMaterial = productMaterialRepository.findByName(material.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductMaterial(productMaterial, pageable);

            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
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
            ProductMaterial productMaterial = productMaterialRepository.findByName(material.get());
            ProductSize productSize = productSizeRepository.findBySize(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductMaterialAndProductSize(productMaterial,
                            productSize,
                            pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
        }

        if (page.isPresent()
                && size.isPresent()
                && !size.get().toString().isEmpty()
                && !brand.isPresent()
                && !category.isPresent()
                && !material.isPresent()
                && !gender.isPresent()
                ) {
            ProductSize productSize = productSizeRepository.findBySize(size.get());
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "isNew"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPages = productRepository.findByProductSize(productSize, pageable);
            List<Product> productList = productPages.getContent();
            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            int pages = productPages.getTotalPages();
            headers.set("Pages", String.valueOf(pages));
            return new ResponseEntity<>(productList, headers, HttpStatus.OK);
        }

        return new ResponseEntity<>(new CustomErrorType(""),
                HttpStatus.NOT_FOUND);

    }
}
