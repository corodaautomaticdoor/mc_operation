package com.coroda.dto.request;

import com.coroda.entity.TypeOperation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Model QuotationStatusRequest")
public class TypeOperationRequest {
    @ApiModelProperty(value = "typeOperation")
    private TypeOperation typeOperation;

}
