package com.springbootrest.model.dto;


import lombok.*;

@Data
@Value
public class CustomerDto {
    Long id;
    String product;
    String description;
    boolean delete;
}
