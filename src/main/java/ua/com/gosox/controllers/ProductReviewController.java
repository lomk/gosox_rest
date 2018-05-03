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
@RequestMapping("/api/product-review")
public class ProductReviewController {
    @Autowired
    ProductReviewRepository productReviewRepository;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<?> listProductReview() {
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
}
