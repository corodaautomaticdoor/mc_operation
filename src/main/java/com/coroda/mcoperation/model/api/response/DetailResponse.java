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
    private List<Product> product;
    private List<NewStyleResponse> newStyle;
    private BigDecimal quantity;
    private BigDecimal totalDetailAmount;

    public BigDecimal getTotalDetailAmount() {
        BigDecimal totalDetail = new BigDecimal(0.0).setScale(2);
        for (Product item : product) {
            totalDetail = quantity.multiply(item.getPriceUnit()).setScale(2);
        }
        return totalDetail;
    }
}
