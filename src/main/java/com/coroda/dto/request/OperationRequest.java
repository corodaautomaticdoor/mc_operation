package com.coroda.dto.request;

import com.coroda.entity.TypeOperation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Model Operation")
public class OperationRequest {

    @ApiModelProperty(value = "operationId", position = 1)
    private Long operationId;

    @ApiModelProperty(value = "typeOperation", required = true , position = 2)
    private TypeOperation typeOperation;

    @ApiModelProperty(value = "date", required = true , position = 3)
    private Date date;

    @ApiModelProperty(value = "client", required = true , position = 4)
    private String client;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ApiModelProperty(position = 5)
    private List<DetailOperationRequest> detailOperation;
}
