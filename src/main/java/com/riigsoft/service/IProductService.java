package com.riigsoft.service;

import com.riigsoft.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Integer saveProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Integer id);

    List<Product> getAllProducts();

    Product getOneProduct(Integer id);


}
