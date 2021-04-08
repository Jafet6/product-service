package com.accenture.orderservice.controllers;

import com.accenture.orderservice.domains.Product;
import com.accenture.orderservice.mappers.ProductMapper;
import com.accenture.orderservice.repository.CategoryRepository;
import com.accenture.orderservice.repository.ProductRepository;
import com.accenture.orderservice.requests.ProductRegisterRequest;
import com.accenture.orderservice.responses.MessageResponse;
import com.accenture.orderservice.responses.ProductDataResponse;
import com.accenture.orderservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    private ResponseEntity<Object> create(@Valid @RequestBody ProductRegisterRequest productRequest) throws Exception {
        Product productDomain = productMapper.convertProductRegisterRequestToEntity(productRequest);
        ProductDataResponse serviceResponse = productService.create(productDomain);
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Long id) {
        MessageResponse message = productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        ProductDataResponse serviceResponse = productService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(serviceResponse);

    }

    @PutMapping("/{id}")
    public Product updateById(@PathVariable("id") Long id, @Valid @RequestBody ProductRegisterRequest productRequest) throws Exception {
        Product product = productMapper.convertProductRegisterRequestToEntity(productRequest);
        ProductDataResponse serviceResponse = productService.updateById(id, product);
        return productRepository.save(product);
    }

    @GetMapping
    private ResponseEntity<List<ProductDataResponse>> findAll() {
        List<ProductDataResponse> serviceResponse = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(serviceResponse);
    }

    @GetMapping("/category/{id}")
    private ResponseEntity<List<ProductDataResponse>> findAllByCategory(@PathVariable("id") Long id) {
        List<ProductDataResponse> serviceResponse = productService.findAllByCategoryId(id);
        return ResponseEntity.status(HttpStatus.OK).body(serviceResponse);
    }

    @GetMapping("/brand/{id}")
    private ResponseEntity<List<ProductDataResponse>> findAllByBrandId(@PathVariable("id") Long id) {
        List<ProductDataResponse> serviceResponse = productService.findAllByBrandId(id);
        return ResponseEntity.status(HttpStatus.OK).body(serviceResponse);
    }
}
