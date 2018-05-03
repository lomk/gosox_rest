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
@RequestMapping("/api/product-brand")
public class ProductBrandController {
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
}
