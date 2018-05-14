package ua.com.gosox.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.gosox.domains.ProductSize;
import ua.com.gosox.errors.CustomErrorType;
import ua.com.gosox.repositories.ProductSizeRepository;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/admin/product-size")
public class AdminProductSizeController {
    @Autowired
    ProductSizeRepository productSizeRepository;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<?> listProductSize() {
        List<ProductSize> productSizes = productSizeRepository.findAll();
        if (productSizes == null){
            return new ResponseEntity(new CustomErrorType("No data found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productSizes, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductSize(@PathVariable("id") Integer id) {
        ProductSize productSize = productSizeRepository.findOne(id);
        if (productSize == null){
            return new ResponseEntity(new CustomErrorType(
                    "ProductSize with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productSize, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProductSize(@PathVariable Integer id, @RequestBody ProductSize productSize){
        ProductSize currentProductSize = productSizeRepository.findOne(id);
        if (currentProductSize == null){
            return new ResponseEntity(new CustomErrorType(
                    "Unable to upate. ProductSize with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        currentProductSize.setSize(productSize.getSize());
        productSizeRepository.save(currentProductSize);
        return new ResponseEntity<>(currentProductSize, HttpStatus.OK);
    }

    @RequestMapping(value="add", method=RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> addProductSize(@RequestBody ProductSize productSize){

        if (productSize == null){
            return new ResponseEntity(new CustomErrorType("No productSize"),HttpStatus.NOT_ACCEPTABLE);
        }
        if (productSize.getSize() == null || productSize.getSize().isEmpty()){
            return new ResponseEntity(new CustomErrorType("No productSize name"),HttpStatus.NOT_ACCEPTABLE);
        }
        if (productSizeRepository.findBySize(productSize.getSize()) != null){
            return new ResponseEntity(new CustomErrorType("Unable to create. A productSize name " +
                    productSize.getSize() + " already exist."),HttpStatus.CONFLICT);
        }
        productSizeRepository.save(productSize);
        return new ResponseEntity<>(productSize, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delProductSize(@PathVariable("id") Integer id) {
        ProductSize productSize = productSizeRepository.findOne(id);
        if (productSize == null ){
            return new ResponseEntity(new CustomErrorType(
                    "ProductSize with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        try {
            productSizeRepository.delete(productSize);
        } catch (Exception e){
            return new ResponseEntity(new CustomErrorType(
                    "SQL error."),
                    HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
