package com.coroda.mcoperation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "new_style_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewStyleProduct {

    @Column(name = "detailOperationId")
    private Long detailOperationId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "newStyleId")
    private Long newStyleId;

    @Column(name = "color")
    private String color;

    @Column(name = "dimention")
    private String dimention;

}
