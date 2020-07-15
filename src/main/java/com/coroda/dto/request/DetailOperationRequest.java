package com.coroda.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.math.BigDecimal;

@Data
@ApiModel("Model DetailOperation")
public class DetailOperationRequest {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "detailOperationId")
    private Long detailOperationId;

    @ApiModelProperty(value = "description")
    private String description;

    @ApiModelProperty(value = "quantity", required = true)
    private BigDecimal quantity;

    @ApiModelProperty(value = "priceUnit", required = true)
    private BigDecimal priceUnit;


}
