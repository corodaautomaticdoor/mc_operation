package com.coroda.mcoperation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "detail_operation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailOperation {

    @Column(name = "operationId")
    private Long operationId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detailId")
    private Long detailId;

    @Column(name = "model")
    private String model;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "newStyleId")
    private List<NewStyleProduct>  newStyleProduct;

    @Column(name = "priceUnit")
    private BigDecimal priceUnit;

    @Column(name = "totalProductPrice")
    private BigDecimal totalProductPrice;

}
