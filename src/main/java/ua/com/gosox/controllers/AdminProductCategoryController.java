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
@RequestMapping("/api/admin/category")
public class AdminProductCategoryController {
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

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProductCategory(@PathVariable Integer id, @RequestBody ProductCategory productCategory){
        ProductCategory currentProductCategory = productCategoryRepository.findOne(id);
        if (currentProductCategory == null){
            return new ResponseEntity(new CustomErrorType(
                    "Unable to upate. ProductCategory with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        currentProductCategory.setCategoryName(productCategory.getCategoryName());
        productCategoryRepository.save(currentProductCategory);
        return new ResponseEntity<>(currentProductCategory, HttpStatus.OK);
    }

    @RequestMapping(value="add", method=RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> addProductCategory(@RequestBody ProductCategory productCategory){

        if (productCategory == null){
            return new ResponseEntity(new CustomErrorType("No productCategory"),HttpStatus.NOT_ACCEPTABLE);
        }
        if (productCategory.getCategoryName() == null || productCategory.getCategoryName().isEmpty()){
            return new ResponseEntity(new CustomErrorType("No productCategory name"),HttpStatus.NOT_ACCEPTABLE);
        }
        if (productCategoryRepository.findByCategoryName(productCategory.getCategoryName()) != null){
            return new ResponseEntity(new CustomErrorType("Unable to create. A productCategory with name " +
                    productCategory.getCategoryName() + " already exist."),HttpStatus.CONFLICT);
        }
        productCategoryRepository.save(productCategory);
        return new ResponseEntity<>(productCategory, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delProductCategory(@PathVariable("id") Integer id) {
        ProductCategory productCategory = productCategoryRepository.findOne(id);
        if (productCategory == null ){
            return new ResponseEntity(new CustomErrorType(
                    "ProductCategory with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        try {
            productCategoryRepository.delete(productCategory);
        } catch (Exception e){
            return new ResponseEntity(new CustomErrorType("SQL error."), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
