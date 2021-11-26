package com.coroda.mcoperation.model.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Model NewStyleRequest")
public class NewStyleRequest {

    @ApiModelProperty(value = "newStyleId", position = 1)
    private Long newStyleId;

    @ApiModelProperty(value = "detailOperationId" , position = 2)
    private Long detailOperationId;

    @ApiModelProperty(value = "color", position = 3)
    private String color;

    @ApiModelProperty(value = "dimention" , position = 4)
    private String dimention;


}
