package com.itschool.challenges.models.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {
    private long id;
    private String name;
    private String category;
    private double price;

}
