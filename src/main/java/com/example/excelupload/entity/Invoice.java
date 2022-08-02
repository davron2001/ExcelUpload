package com.example.excelupload.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double amount;
    private String number;
    private String receivedDate;
}
