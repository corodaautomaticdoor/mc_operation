package com.coroda.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "detailOperation")
@Data
@ApiModel("Model DetailOperation")
public class DetailOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "detailOperationId")
    @ApiModelProperty(value = "The DetailOperation is detailOperationId")
    @Column(name = "detailOperationId")
    private String detailOperationId;

/*    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    private List<Product> productId;*/

    @NotNull
    @ApiModelProperty(value = "The DetailOperation is quantity", required = true)
    @Column(name = "quantity")
    private String quantity;

    @NotNull
    @ApiModelProperty(value = "The DetailOperation is price", required = true)
    @Column(name = "price")
    private String price;

}
