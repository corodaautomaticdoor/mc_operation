package com.coroda.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailOperationResponse {

    private String detailOperationId;
    /* private List<Product> productId;*/
    private String quantity;
    private String price;

}
