package com.coroda.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.math.BigDecimal;

@Data
@ApiModel("Model DetailOperation")
public class DetailOperationRequest {

    @ApiModelProperty(value = "detailOperationId", position = 1)
    private Long detailOperationId;

    @ApiModelProperty(value = "id" , position = 2)
    private Long id;

    @ApiModelProperty(value = "description" , position = 3)
    private String description;

    @ApiModelProperty(value = "quantity", required = true , position = 4)
    private BigDecimal quantity;

    @ApiModelProperty(value = "priceUnit", required = true , position = 5)
    private BigDecimal priceUnit;


}
