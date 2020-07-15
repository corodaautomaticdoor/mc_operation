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

    @ApiModelProperty(value = "operationId")
    private Long operationId;

    @ApiModelProperty(value = "typeOperation", required = true)
    private TypeOperation typeOperation;

    @ApiModelProperty(value = "date", required = true)
    private Date date;

    @ApiModelProperty(value = "client", required = true)
    private String client;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DetailOperationRequest> detailOperation;
}
