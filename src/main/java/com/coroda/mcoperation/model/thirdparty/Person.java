package com.coroda.mcoperation.model.thirdparty;

import lombok.Data;

@Data
public class Person {

    private long idPerson;
    private String typeDocument;
    private String typePerson;
    private long numberDocument;
    private String name;
    private String lastName1;
    private String lastName2;
    private String socialReason;
    private String address;
    private String email;
    private long phone;

}
