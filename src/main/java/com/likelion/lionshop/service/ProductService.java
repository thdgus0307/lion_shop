package com.likelion.lionshop.service;

import com.likelion.lionshop.dto.request.CreateProductRequestDto;
import com.likelion.lionshop.dto.request.UpdateProductRequestDto;
import com.likelion.lionshop.dto.response.ProductResponseDto;
import com.likelion.lionshop.entity.Product;
import com.likelion.lionshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;


    public void createProduct(CreateProductRequestDto createProductRequestDto){
        Product product = createProductRequestDto.toEntity();
        productRepository.save(product);
    }// 상품 저장

    public ProductResponseDto getProduct(Long productId){
        Product product = productRepository.findById(productId).orElseThrow();
        ProductResponseDto dto = ProductResponseDto.from(product);
        return dto;
    }// 상품 조회

    public void updateProduct(UpdateProductRequestDto updateProductRequestDto){
        Optional<Product> optionalProduct = productRepository.findById(updateProductRequestDto.getProductId());

        Product product = productRepository.findById(updateProductRequestDto.getProductId()).orElseThrow(
                ()-> new IllegalArgumentException("상품이 존재하지 않습니다."));

        product.update(updateProductRequestDto.getProductName(), updateProductRequestDto.getProductPrice());
        productRepository.save(product);

    }

   public void deleteProduct(Long productId){
        Product product = productRepository.findById(productId).orElseThrow(
                ()-> new IllegalArgumentException("상품이 존재하지 않습니다."));

        productRepository.deleteById(product.getProductId());
   }

}
