
package com.riigsoft.controller;

import com.riigsoft.model.Product;
import com.riigsoft.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * This is complete API project for learners .
 * They can practice and keep there resume to job.
 *
 * @author Abdallah Mahmoud.
 * You can contact me through {@link https://www.linkedin.com/in/abdallahmahmud/}

 * */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService service;

    @GetMapping("/all")
   public ResponseEntity<List<Product>>getAll(){
       return new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product>getOne(@PathVariable Integer id){
        return new ResponseEntity<>(service.getOneProduct(id),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Integer>save(@RequestBody Product product){
        return new ResponseEntity<>(service.saveProduct(product),HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?>update(@RequestBody Product product){
        service.updateProduct(product);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
