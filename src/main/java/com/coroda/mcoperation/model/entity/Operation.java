package com.coroda.mcoperation.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operationId;

    @Column(name = "typeOperation")
    private TypeOperation typeOperation;

    @Column(name = "date")
    private String date;

    @Column(name = "numberDocument")
    private Long numberDocument;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "operationId")
    private List<DetailOperation> detailOperacion;

    @Column(name = "totalAmount")
    private BigDecimal totalAmount;

}
