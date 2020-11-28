package com.coroda.mcoperation.model.api.request;

import com.coroda.mcoperation.model.entity.TypeOperacion;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Data
@ApiModel("Model Request")
public class Request {

    @ApiModelProperty(value = "operationId", position = 1)
    private Long operationId;

    @ApiModelProperty(value = "typeOperation", required = true , position = 2)
    private TypeOperacion typeOperation;

//    @ApiModelProperty(value = "date", required = true , position = 3)
//    private String date;

    @ApiModelProperty(value = "numberDocument", required = true , position = 4)
    private Long numberDocument;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ApiModelProperty(position = 5)
    private List<DetailRequest> detail;

    public String getDate(){
        Date fecha = new Date();
        String Fecha = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(fecha);
        String fe = Fecha.toString();
        return fe;
    }

}
