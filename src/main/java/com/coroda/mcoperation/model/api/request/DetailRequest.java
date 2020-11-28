package com.coroda.mcoperation.model.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("Model DetailRequest")
public class DetailRequest {

    @ApiModelProperty(value = "detailOperationId", position = 1)
    private Long detailOperationId;

    @ApiModelProperty(value = "id" , position = 2)
    private Long id;

    @ApiModelProperty(value = "description" , position = 3)
    private String model;

    @ApiModelProperty(value = "quantity", required = true , position = 4)
    private BigDecimal quantity;


}
