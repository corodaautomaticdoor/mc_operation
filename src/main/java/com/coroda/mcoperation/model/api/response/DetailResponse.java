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
    private String model;
//    private List<ProductResponse> product;
    private ProductResponse product;
    private List<NewStyleResponse> newStyleProduct;
    private BigDecimal quantity;
    private BigDecimal priceUnit;
    private BigDecimal totalDetailAmount;

}
