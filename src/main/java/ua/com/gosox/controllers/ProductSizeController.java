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
@RequestMapping("/api/product-size")
public class ProductSizeController {
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
}
