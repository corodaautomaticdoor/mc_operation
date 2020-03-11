package com.coroda.model;

import lombok.Data;

@Data
public class Sale {

    private String id_sale;
    private String id_detail_sale;
    private String id_payment;
    private String date;
    private String id_user;

}
