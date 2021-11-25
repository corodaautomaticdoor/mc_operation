package com.coroda.mcoperation.model.api.response;

import com.coroda.mcoperation.model.thirdparty.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailResponse {

    private Long detailId;
    private Long operationId;
    private List<Product> product;
    private List<NewStyleResponse> newStyle;
    private BigDecimal quantity;
    private BigDecimal priceUnit;
    private BigDecimal totalDetailAmount;

}
