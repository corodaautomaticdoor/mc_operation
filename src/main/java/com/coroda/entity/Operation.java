package com.coroda.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "operation")
@Data
@ApiModel
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Operation {

}
