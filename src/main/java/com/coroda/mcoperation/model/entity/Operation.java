package com.coroda.mcoperation.model.entity;

import lombok.Data;

import javax.persistence.*;
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
    @JoinColumn(name = "id")
    private List<DetailOperation> detailOperacion;


//    public BigDecimal getTotalAmount() {
//        BigDecimal total = new BigDecimal(0.0).setScale(2);
//        for (DetailOperacion item : detailOperacion) {
//            total = total.add(item.getTotalDetail().setScale(2));
//        }
//        return total;
//    }

}
