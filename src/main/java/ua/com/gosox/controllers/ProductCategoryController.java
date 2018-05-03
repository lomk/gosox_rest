package ua.com.gosox.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.gosox.domains.ProductCategory;
import ua.com.gosox.errors.CustomErrorType;
import ua.com.gosox.repositories.ProductCategoryRepository;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/product-category")
public class ProductCategoryController {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<?> listProductCategory() {
        List<ProductCategory> productCategories = productCategoryRepository.findAll();
        if (productCategories == null){
            return new ResponseEntity(new CustomErrorType("No data found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productCategories, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductCategory(@PathVariable("id") Integer id) {
        ProductCategory productCategory = productCategoryRepository.findOne(id);
        if (productCategory == null){
            return new ResponseEntity(new CustomErrorType(
                    "ProductCategory with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productCategory, HttpStatus.OK);
    }
}
