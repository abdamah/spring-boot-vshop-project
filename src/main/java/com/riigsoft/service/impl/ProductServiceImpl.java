package com.riigsoft.service.impl;

import com.riigsoft.exception.ProductNotFound;
import com.riigsoft.model.Product;
import com.riigsoft.repo.ProductRepository;
import com.riigsoft.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.UUID;
/**
 * This is complete API project for learners .
 * They can practice and keep there resume to job.
 *
 * @author Abdallah Mahmoud.
 * You can contact me through {@link https://www.linkedin.com/in/abdallahmahmud/}

 * */
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductRepository repo;

    @Override
    @Transactional
    public Integer saveProduct(Product product) {
        product.setProdCode(UUID.randomUUID().toString());
        return repo.save(product).getId();
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        repo.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Integer id) {
        repo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product getOneProduct(Integer id) {
        return repo.findById(id).orElseThrow(() ->
                new ProductNotFound("Product with " + id + " not found.")
        );
    }
}
