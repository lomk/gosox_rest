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
@RequestMapping("/api/admin/product-gender")
public class AdminProductGenderController {
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

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProductGender(@PathVariable Integer id, @RequestBody ProductGender productGender){
        ProductGender currentProductGender = productGenderRepository.findOne(id);
        if (currentProductGender == null){
            return new ResponseEntity(new CustomErrorType(
                    "Unable to upate. ProductGender with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        currentProductGender.setName(productGender.getName());
        productGenderRepository.save(currentProductGender);
        return new ResponseEntity<>(currentProductGender, HttpStatus.OK);
    }

    @RequestMapping(value="add", method=RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> addProductGender(@RequestBody ProductGender productGender){

        if (productGender == null){
            return new ResponseEntity(new CustomErrorType("No productGender"),HttpStatus.NOT_ACCEPTABLE);
        }
        if (productGender.getName() == null || productGender.getName().isEmpty()){
            return new ResponseEntity(new CustomErrorType("No productGender name"),HttpStatus.NOT_ACCEPTABLE);
        }
        if (productGenderRepository.findByName(productGender.getName()) != null){
            return new ResponseEntity(new CustomErrorType("Unable to create. A productGender name " +
                    productGender.getName() + " already exist."),HttpStatus.CONFLICT);
        }
        productGenderRepository.save(productGender);
        return new ResponseEntity<>(productGender, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delProductGender(@PathVariable("id") Integer id) {
        ProductGender productGender = productGenderRepository.findOne(id);
        if (productGender == null ){
            return new ResponseEntity(new CustomErrorType(
                    "ProductGender with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        try {
            productGenderRepository.delete(productGender);
        } catch (Exception e){
            return new ResponseEntity(new CustomErrorType(
                    "SQL error."),
                    HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
