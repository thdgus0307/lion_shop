package com.likelion.lionshop.controller;

import com.likelion.lionshop.dto.request.CreateProductRequestDto;
import com.likelion.lionshop.dto.request.UpdateProductRequestDto;
import com.likelion.lionshop.dto.response.ProductResponseDto;
import com.likelion.lionshop.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@Slf4j //로그 출력을 도와주는 어노테이션
@RestController
@RequestMapping("/product") // uri가 /product로 시작하는 요청을 받습니다.
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping("/create")
    public String createProduct(@Valid @RequestBody CreateProductRequestDto createProductRequestDto){
        log.info("상품명: {}", createProductRequestDto.getProductName());
        log.info("가격: {}", createProductRequestDto.getProductPrice());

        productService.createProduct(createProductRequestDto);

        return "상품 생성";

    }

    @GetMapping("/{productId}")
    public ProductResponseDto getProduct(@PathVariable Long productId){
        ProductResponseDto productResponseDto = productService.getProduct(productId);
        return productResponseDto;
    }

    @PutMapping()
    public String updateProduct(@RequestBody UpdateProductRequestDto updateProductRequestDto){
        productService.updateProduct(updateProductRequestDto);
        return "상품 수정하기";
    }
    
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long productId){
        log.info("ProductId: {}", productId);
        productService.deleteProduct(productId);

        return "상품 삭제하기";
    }
}
