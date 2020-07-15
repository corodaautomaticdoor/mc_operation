package com.coroda.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "operationId")
    @Column(name = "operationId")
    private Long operationId;

    @Column(name = "typeOperation")
    private TypeOperation typeOperation;

    @Column(name = "date")
    private Date date;

    @Column(name = "client")
    private String client;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private List<DetailOperation> detailOperation;


    public BigDecimal getTotalAmount() {
        BigDecimal total = new BigDecimal(0.0).setScale(2);
        for (DetailOperation item : detailOperation) {
            total = total.add(item.getTotalDetail().setScale(2));
        }
        return total;
    }

}
