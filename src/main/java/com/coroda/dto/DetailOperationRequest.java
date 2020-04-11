package com.coroda.dto;

import lombok.Data;

@Data
public class DetailOperationRequest {

    private String detailOperationId;
    /* private List<Product> productId;*/
    private String quantity;
    private String price;


}
