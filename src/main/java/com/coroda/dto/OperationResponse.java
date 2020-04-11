package com.coroda.dto;

import lombok.*;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationResponse {

    private String operationId;
    private String typeOperation;
    /*private String id_user;*/
    @Singular
    private List<DetailOperationResponse> detailOperationId;
    /*private String paymentId;*/
    private String date;


}
