package com.coroda.expose.web;

import com.coroda.mcoperation.bussines.OperacionService;
import com.coroda.mcoperation.model.api.request.Request;
import com.coroda.mcoperation.model.api.response.Response;
import com.coroda.mcoperation.util.Constants;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.MAIN_PATH)
@Api(tags = "Microservicio Operation", description = "Esta API se encarga de la gestion de las Operaciones")
@Slf4j
public class OperacionController {

    @Autowired
    OperacionService operacionService;

    @PostMapping
    @ApiOperation(value = Constants.SAVE_VALUE, notes = Constants.SAVE_NOTE)
    public Completable saveretrofit(@RequestBody Request request) {
        log.info("Envio de parametros");
        return operacionService.saveretrofit(request);
    }

    @GetMapping(Constants.ID)
    @ApiOperation(value = Constants.GET_ID_VALUE, notes = Constants.GET_ID_NOTE)
    public Observable<Response> getById(@PathVariable("id") Long operationId) {
        log.info("Obtencion de datos por id");
        return operacionService.getById(operationId);
    }
}