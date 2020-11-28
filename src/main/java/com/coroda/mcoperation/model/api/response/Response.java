package com.coroda.mcoperation.model.api.response;


import com.coroda.mcoperation.model.entity.DetailOperacion;
import com.coroda.mcoperation.model.entity.TypeOperacion;
import com.coroda.mcoperation.model.thirdparty.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private Long operationId;
    private TypeOperacion typeOperation;
    private String date;
    private String hora;
    private List<Person> person;
    private BigDecimal totalAmount;

    private List<DetailResponse> detail;

      public BigDecimal getTotalAmount() {
        BigDecimal total = new BigDecimal(0.0).setScale(2);
        for (DetailResponse item : detail) {
            total = total.add(item.getTotalDetailAmount().setScale(2));
        }
        return total;
    }
}
