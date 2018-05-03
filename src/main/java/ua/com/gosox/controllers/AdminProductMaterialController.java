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
@RequestMapping("/api/admin/product-material")
public class AdminProductMaterialController {
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

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProductMaterial(@PathVariable Integer id, @RequestBody ProductMaterial productMaterial){
        ProductMaterial currentProductMaterial = productMaterialRepository.findOne(id);
        if (currentProductMaterial == null){
            return new ResponseEntity(new CustomErrorType(
                    "Unable to upate. ProductMaterial with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        currentProductMaterial.setMaterialName(productMaterial.getMaterialName());
        productMaterialRepository.save(currentProductMaterial);
        return new ResponseEntity<>(currentProductMaterial, HttpStatus.OK);
    }

    @RequestMapping(value="add", method=RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> addProductMaterial(@RequestBody ProductMaterial productMaterial){

        if (productMaterial == null){
            return new ResponseEntity(new CustomErrorType("No productMaterial"),HttpStatus.NOT_ACCEPTABLE);
        }
        if (productMaterial.getMaterialName() == null || productMaterial.getMaterialName().isEmpty()){
            return new ResponseEntity(new CustomErrorType("No productMaterial name"),HttpStatus.NOT_ACCEPTABLE);
        }
        if (productMaterialRepository.findByMaterialName(productMaterial.getMaterialName()) != null){
            return new ResponseEntity(new CustomErrorType("Unable to create. A productMaterial name " +
                    productMaterial.getMaterialName() + " already exist."),HttpStatus.CONFLICT);
        }
        productMaterialRepository.save(productMaterial);
        return new ResponseEntity<>(productMaterial, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delProductMaterial(@PathVariable("id") Integer id) {
        ProductMaterial productMaterial = productMaterialRepository.findOne(id);
        if (productMaterial == null ){
            return new ResponseEntity(new CustomErrorType(
                    "ProductMaterial with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        try {
            productMaterialRepository.delete(productMaterial);
        } catch (Exception e){
            return new ResponseEntity(new CustomErrorType(
                    "SQL error."),
                    HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
