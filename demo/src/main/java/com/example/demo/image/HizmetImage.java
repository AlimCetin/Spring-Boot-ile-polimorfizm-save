package com.example.demo.image;

import com.example.demo.products.BaseProduct;
import com.example.demo.products.Hizmet;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class HizmetImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] data;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "hizmet_id")
    private Hizmet hizmet;
}