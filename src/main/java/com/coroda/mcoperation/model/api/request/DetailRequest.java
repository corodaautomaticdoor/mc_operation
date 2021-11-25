package com.coroda.mcoperation.model.api.request;

import com.coroda.mcoperation.model.thirdparty.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel("Model DetailRequest")
public class DetailRequest {

    @ApiModelProperty(value = "id", position = 1)
    private Long id;

    @ApiModelProperty(value = "operationId" , position = 2)
    private Long operationId;

    @ApiModelProperty(value = "description" , position = 3)
    private String model;

    @ApiModelProperty(value = "quantity", required = true , position = 4)
    private BigDecimal quantity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ApiModelProperty(position = 5)
    private List<NewStyleRequest> newStyleProduct;

    @ApiModelProperty(value = "priceUnit", required = true , position = 6)
    private BigDecimal priceUnit;

    public BigDecimal getTotalDetailAmount() {
        BigDecimal totalDetail = new BigDecimal(0.0).setScale(2);
//        for (Product item : product) {
            totalDetail = quantity.multiply(priceUnit).setScale(2);
//        }
        return totalDetail;
    }

}
