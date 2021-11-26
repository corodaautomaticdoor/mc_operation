package com.coroda.mcoperation.model.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewStyleResponse {
    private Long newStyleId;
//    private Long detailOperationId;
    private String color;
    private String dimention;
}
