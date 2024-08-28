package com.example.demo.dto;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.example.demo.dto.image.HizmetImage;
import com.example.demo.products.Hizmet;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HizmetDto extends BaseProductDto {

    @Column(name = "verhizmet")
    private String verhizmet;

   @OneToMany(mappedBy = "hizmetDto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HizmetImage> hizmetImages ;
 

 public Hizmet toProductEntity() {
    Hizmet hizmet = new Hizmet();
    // iki nesne arasında veri aktarımını kolaylaştırır.
    // Özellikle, benzer yapıya sahip (aynı özellik isimlerine ve uyumlu türlere
    // sahip) nesneler arasında veri transferi yapmanız gerektiğinde kullanışlıdır.
    BeanUtils.copyProperties(this, hizmet);
    return hizmet;

}
}