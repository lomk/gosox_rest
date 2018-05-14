package ua.com.gosox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.gosox.domains.ProductBrand;
import ua.com.gosox.errors.CustomErrorType;
import ua.com.gosox.repositories.ProductBrandRepository;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/admin/product-brand")
public class AdminProductBrandController {

    @Autowired
    ProductBrandRepository productBrandRepository;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<?> listProductBrand() {
        List<ProductBrand> productBrands = productBrandRepository.findAll();
        if (productBrands == null){
            return new ResponseEntity(new CustomErrorType("No data found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productBrands, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductBrand(@PathVariable("id") Integer id) {
        ProductBrand productBrand = productBrandRepository.findOne(id);
        if (productBrand == null){
            return new ResponseEntity(new CustomErrorType(
                    "ProductBrand with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productBrand, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProductBrand(@PathVariable Integer id, @RequestBody ProductBrand productBrand){
        ProductBrand currentProductBrand = productBrandRepository.findOne(id);
        if (currentProductBrand == null){
            return new ResponseEntity(new CustomErrorType(
                    "Unable to upate. ProductBrand with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        currentProductBrand.setName(productBrand.getName());
        productBrandRepository.save(currentProductBrand);
        return new ResponseEntity<>(currentProductBrand, HttpStatus.OK);
    }

    @RequestMapping(value="add", method=RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> addProductBrand(@RequestBody ProductBrand productBrand){

        if (productBrand == null){
            return new ResponseEntity(new CustomErrorType("No productBrand"),HttpStatus.NOT_ACCEPTABLE);
        }
        if (productBrand.getName() == null || productBrand.getName().isEmpty()){
            return new ResponseEntity(new CustomErrorType("No productBrand name"),HttpStatus.NOT_ACCEPTABLE);
        }
        if (productBrandRepository.findByName(productBrand.getName()) != null){
            return new ResponseEntity(new CustomErrorType("Unable to create. A productBrand name " +
                    productBrand.getName() + " already exist."),HttpStatus.CONFLICT);
        }
        productBrandRepository.save(productBrand);
        return new ResponseEntity<>(productBrand, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delProductBrand(@PathVariable("id") Integer id) {
        ProductBrand productBrand = productBrandRepository.findOne(id);
        if (productBrand == null ){
            return new ResponseEntity(new CustomErrorType(
                    "ProductBrand with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        try {
            productBrandRepository.delete(productBrand);
        } catch (Exception e){
            return new ResponseEntity(new CustomErrorType(
                    "SQL error."),
                    HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
