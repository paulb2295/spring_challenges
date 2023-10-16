package com.itschool.challenges.services;

import com.itschool.challenges.models.dtos.ProductDTO;
import com.itschool.challenges.models.entities.Product;


import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long id);

    String deleteById(Long id);

    //ProductDTO editProduct(Long id, ProductDTO productDTO);
}
