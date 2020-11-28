package com.coroda.mcoperation.model.entity;

import com.coroda.mcoperation.model.thirdparty.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detail_operation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailOperation {

    @Column(name = "id")
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detailOperationId")
    private Long detailOperationId;

    @Column(name = "model")
    private String model;

    @Column(name = "quantity")
    private BigDecimal quantity;

//    @Column(name = "price")
//    private BigDecimal priceUnit;

//    public BigDecimal getTotalDetail() {
//        return priceUnit.multiply(quantity).setScale(2);
//    }

}
