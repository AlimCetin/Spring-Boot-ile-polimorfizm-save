package com.example.demo.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.example.demo.products.BaseProduct;
import com.example.demo.products.Elektronik;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// SuperBuilder = üstteki değişkenleri alta aktarır ve direkt getname() gibi
// ifade kullanılarak işlam yapılır
// @SuperBuilder
public class ElektronikDto extends BaseProductDto {
    @Column(name = "elektronikName")
    private String elektronikName;

    public Elektronik toProductEntity() {
        Elektronik elektronik = new Elektronik();
        // iki nesne arasında veri aktarımını kolaylaştırır.
        // Özellikle, benzer yapıya sahip (aynı özellik isimlerine ve uyumlu türlere
        // sahip) nesneler arasında veri transferi yapmanız gerektiğinde kullanışlıdır.
        BeanUtils.copyProperties(this, elektronik);
        return elektronik;

    }

}
