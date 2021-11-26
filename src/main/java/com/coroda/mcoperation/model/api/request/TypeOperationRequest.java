package com.coroda.mcoperation.model.api.request;

import com.coroda.mcoperation.model.entity.TypeOperation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Model QuotationStatusRequest")
public class TypeOperationRequest {
    @ApiModelProperty(value = "typeOperation")
    private TypeOperation typeOperation;

}
