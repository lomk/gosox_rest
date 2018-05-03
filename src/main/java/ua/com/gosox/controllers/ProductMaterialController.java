package ua.com.gosox.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.gosox.domains.ProductMaterial;
import ua.com.gosox.errors.CustomErrorType;
import ua.com.gosox.repositories.ProductMaterialRepository;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/product-composition")
public class ProductMaterialController {
    @Autowired
    ProductMaterialRepository productMaterialRepository;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<?> listProductMaterial() {
        List<ProductMaterial> productMaterials = productMaterialRepository.findAll();
        if (productMaterials == null){
            return new ResponseEntity(new CustomErrorType("No data found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productMaterials, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductMaterial(@PathVariable("id") Integer id) {
        ProductMaterial productMaterial = productMaterialRepository.findOne(id);
        if (productMaterial == null){
            return new ResponseEntity(new CustomErrorType(
                    "ProductMaterial with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productMaterial, HttpStatus.OK);
    }
}
