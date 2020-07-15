package com.coroda.dto.response;


import com.coroda.entity.TypeOperation;
import lombok.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationResponse {

    private Long operationId;
    private TypeOperation typeOperation;
    private Date date;
    private String client;
    private BigDecimal totalAmount;

    private List<DetailOperationResponse> detailOperation;

}
