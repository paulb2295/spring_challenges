package com.itschool.challenges.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.challenges.models.dtos.ProductDTO;
import com.itschool.challenges.models.entities.Product;
import com.itschool.challenges.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    public ProductServiceImpl(ProductRepository productRepository, ObjectMapper objectMapper) {
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product productEntity = objectMapper.convertValue(productDTO, Product.class);
        Product productResponseEntity = productRepository.save(productEntity);
        return objectMapper.convertValue(productResponseEntity, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productList) {
            productDTOList.add(objectMapper.convertValue(product, ProductDTO.class));
        }
        return productDTOList;
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return objectMapper.convertValue(product.orElse(null), ProductDTO.class);
        //return objectMapper.convertValue(productRepository.getReferenceById(id), ProductDTO.class);
    }

    @Override
    public String deleteById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "Item deleted";
        }
        return "Item does not exist";
    }

//    @Override
//    public ProductDTO editProduct(Long id, ProductDTO productDTO) {
//        if(productRepository.existsById(id)){
//
//        }
//    }
}
