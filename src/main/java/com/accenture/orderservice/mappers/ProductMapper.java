package com.accenture.orderservice.mappers;

import com.accenture.orderservice.domains.Product;
import com.accenture.orderservice.requests.ProductRegisterRequest;
import com.accenture.orderservice.responses.ProductDataResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.List;

public class ProductMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDataResponse convertProductDomainToProductResponse(Product product) {
        ProductDataResponse productDataResponse = modelMapper.map(product, ProductDataResponse.class);
        return productDataResponse;
    }

    public Product convertProductRegisterRequestToEntity(ProductRegisterRequest productRequest) throws ParseException {
        Product productModel = modelMapper.map(productRequest, Product.class);
        return productModel;
    }
//
//    public User convertUserLoginRequestToEntity(UserLoginRequest userRequest) throws ParseException {
//        User userModel = modelMapper.map(userRequest, User.class);
//        return userModel;
//    }
}
