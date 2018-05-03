package ua.com.gosox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.gosox.domains.ProductGender;
import ua.com.gosox.errors.CustomErrorType;
import ua.com.gosox.repositories.ProductGenderRepository;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/product-gender")
public class ProductGenderController {
    @Autowired
    ProductGenderRepository productGenderRepository;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<?> listProductGender() {
        List<ProductGender> productGenders = productGenderRepository.findAll();
        if (productGenders == null){
            return new ResponseEntity(new CustomErrorType("No data found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productGenders, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductGender(@PathVariable("id") Integer id) {
        ProductGender productGender = productGenderRepository.findOne(id);
        if (productGender == null){
            return new ResponseEntity(new CustomErrorType(
                    "ProductGender with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productGender, HttpStatus.OK);
    }
}
