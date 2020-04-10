package com.coroda.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "quotation")
@Data
@ApiModel("Model Quotation")
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_quotation")
    @ApiModelProperty(value = "id_quotation")
    @Column(name = "id_quotation")
    private String id_quotation;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_detail")
    private List<DetailOperation> id_detail_quotation;

    @NotNull
    @ApiModelProperty(value = "The Card's BinNumber", required = true)
    @Column(name = "date")
    private String date;

  /*  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private String id_user;*/
}
