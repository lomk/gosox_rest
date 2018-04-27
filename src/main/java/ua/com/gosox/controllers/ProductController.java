package ua.com.gosox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.gosox.domains.Product;
import ua.com.gosox.errors.CustomErrorType;
import ua.com.gosox.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<?> articleList(
            @RequestParam(value = "page", required = false) Optional<Integer> page,
            @RequestParam(value = "brand", required = false) Optional<Integer> brand,
            @RequestParam(value = "category", required = false) Optional<Integer> category,
            @RequestParam(value = "size", required = false) Optional<Integer> size,
            @RequestParam(value = "material", required = false) Optional<Integer> material,
            @RequestParam(value = "gender", required = false) Optional<Integer> gender,
    ) {
        if (page.isPresent()
                && !brand.isPresent()
                && !category.isPresent()
                && !size.isPresent()
                && !material.isPresent()
                && !gender.isPresent()
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
                && !category.isPresent()
                && !size.isPresent()
                && !material.isPresent()
                && !gender.isPresent()
                ) {
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "dateField"));
            Pageable pageable = new PageRequest(page.get(), 19, sort);
            Page<Product> productPage = productRepository.findByBrand(pageable);
            List<Product> productList = productPage.getContent();

            if (productList == null) {
                return new ResponseEntity<>(new CustomErrorType("No data found"),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }




        return new ResponseEntity<>(new CustomErrorType(
                    "Bad parameters"),
                    HttpStatus.NOT_ACCEPTABLE);

    }
}
