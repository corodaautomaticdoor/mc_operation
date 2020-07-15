package com.coroda.dto.response;

import lombok.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailOperationResponse {

    private Long detailOperationId;
    private Long id;
    private String description;
    private BigDecimal quantity;
    private BigDecimal priceUnit;
    private BigDecimal totalDetailAmount;

}
