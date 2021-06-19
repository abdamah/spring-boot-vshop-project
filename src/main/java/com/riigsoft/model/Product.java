package com.riigsoft.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name = "product_tab")
public class Product  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false,nullable = false)
    private  Integer id;
    private String prodName;
    private Double prodPrice;
    private String imageUrl;

    @Column(updatable = false,nullable = false)
    private String prodCode;
}
