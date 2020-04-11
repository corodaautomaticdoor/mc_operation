package com.coroda.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "operation")
@Data
@ApiModel("Model Operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "operationId")
    @ApiModelProperty(value = "operationId")
    @Column(name = "The Operation is operationId")
    private String operationId;

    @NotNull
    @ApiModelProperty(value = "The Operation is typeOperation", required = true)
    @Column(name = "typeOperation")
    private String typeOperation;

      /*  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private String id_user;*/

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "detailOperationId")
    private List<DetailOperation> detailOperationId;

    /*  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "paymentId")
    private String paymentId;*/

    @NotNull
    @ApiModelProperty(value = "The Operation is date", required = true)
    @Column(name = "date")
    private String date;

}
