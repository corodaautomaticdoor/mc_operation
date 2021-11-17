package com.coroda.mcoperation.model.api.response;


import com.coroda.mcoperation.model.entity.TypeOperation;
import com.coroda.mcoperation.model.thirdparty.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private Long operationId;
    private TypeOperation typeOperation;
    private String date;
    private String hora;
    private Person person;
    private List<DetailResponse> detail;
    private BigDecimal totalAmount;

      public BigDecimal getTotalAmount() {
        BigDecimal total = new BigDecimal(0.0).setScale(2);
        for (DetailResponse item : detail) {
            total = total.add(item.getTotalDetailAmount().setScale(2));
        }
        return total;
    }
}
