package ua.com.gosox.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.gosox.domains.ProductReview;
import ua.com.gosox.errors.CustomErrorType;
import ua.com.gosox.repositories.ProductReviewRepository;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/admin/product-review")
public class AdminProductReviewController {

    @Autowired
    ProductReviewRepository productReviewRepository;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<?> listProductReviews() {
        List<ProductReview> productReviews = productReviewRepository.findAll();
        if (productReviews == null){
            return new ResponseEntity(new CustomErrorType("No data found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productReviews, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductReview(@PathVariable("id") Integer id) {
        ProductReview productReview = productReviewRepository.findOne(id);
        if (productReview == null){
            return new ResponseEntity(new CustomErrorType(
                    "ProductReview with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productReview, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProductReview(@PathVariable Integer id, @RequestBody ProductReview productReview){
        ProductReview currentProductReview = productReviewRepository.findOne(id);
        if (currentProductReview == null){
            return new ResponseEntity(new CustomErrorType(
                    "Unable to upate. ProductReview with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productReview, HttpStatus.OK);
    }

    @RequestMapping(value="add", method=RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> addProductReview(@RequestBody ProductReview productReview){

        if (productReview == null){
            return new ResponseEntity(new CustomErrorType("No productReview"),HttpStatus.NOT_ACCEPTABLE);
        }
        productReviewRepository.save(productReview);
        return new ResponseEntity<>(productReview, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delProductReview(@PathVariable("id") Integer id) {
        ProductReview productReview = productReviewRepository.findOne(id);
        if (productReview == null ){
            return new ResponseEntity(new CustomErrorType(
                    "ProductReview with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        try {
            productReviewRepository.delete(productReview);
        } catch (Exception e){
            return new ResponseEntity(new CustomErrorType(
                    "SQL error."),
                    HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
