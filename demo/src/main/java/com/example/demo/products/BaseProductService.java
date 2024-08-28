package com.example.demo.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.BaseProductDto;

import java.time.LocalDate;

@Service
public class BaseProductService {

    @Autowired
    private BaseProductRepository baseProductRepository;

    public BaseProduct save(BaseProductDto baseProductDto) {
        if (baseProductDto != null) {
            BaseProduct newProduct = baseProductDto.toProductEntity();
            newProduct.setStatus(true);
            newProduct.setUptodate(LocalDate.now());
            baseProductRepository.save(newProduct);
            return newProduct;
        }
        return null;
    }
}
