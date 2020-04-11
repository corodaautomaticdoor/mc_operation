package com.coroda.dto;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class OperationRequest {

    private String operationId;
    private String typeOperation;
    /*private String id_user;*/
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DetailOperationRequest> detailOperationId;
    /*private String paymentId;*/
    private String date;


}
