package com.coroda.controller;

import com.coroda.dto.request.OperationRequest;
import com.coroda.dto.request.TypeOperationRequest;
import com.coroda.dto.response.OperationResponse;
import com.coroda.dto.response.TypeOperationResponse;
import com.coroda.service.OperationService;
import com.coroda.util.Constants;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Map;

@RestController
@RequestMapping(Constants.MAIN_PATH)
@Api(tags = "Microservicio Operation", description = "Esta API se encarga de la gestion de las Operaciones")
@Slf4j
public class OperationController {

    @Autowired
    OperationService operationService;

    @PostMapping
    @ApiOperation(value = Constants.SAVE_VALUE, notes = Constants.SAVE_NOTE)
    public Completable save(@RequestBody OperationRequest model) {
        log.info("Envio de parametros");
        return operationService.save(model);
    }

    @DeleteMapping(Constants.ID)
    @ApiOperation(value = Constants.DELETE_ID_VALUE, notes = Constants.DELETE_ID_NOTE)
    public Completable delete(@PathVariable("id") Long operationId) {
        log.info("Eliminar datos por id");
        return operationService.delete(operationId);
    }

    @PutMapping(Constants.ID)
    @ApiOperation(value = Constants.UPDATE_ID_VALUE, notes = Constants.UPDATE_ID_NOTE)
    public Completable update(@RequestBody OperationRequest model) {
        log.info("Actualizacion de parametros");
        return operationService.update(model);
    }

    @GetMapping(Constants.ID)
    @ApiOperation(value = Constants.GET_ID_VALUE, notes = Constants.GET_ID_NOTE)
    public Single<OperationResponse> getById(@PathVariable("id") Long operationId) {
        log.info("Obtencion de datos por id");
        return operationService.getById(operationId);
    }

    @GetMapping
    @ApiOperation(value = Constants.GETDATA_VALUE, notes = Constants.GETDATA_NOTE)
    public Observable<OperationResponse> getData(@RequestParam Map<String, String> params) {
        log.info("Enviando parametros de busqueda");
        return operationService.getData(params);
    }

    @PutMapping(Constants.TYPE)
    @ApiOperation(value = Constants.UPDATE_TYPEOPERATION_VALUE, notes = Constants.UPDATE_TYPEOPERATION_NOTE)
    public Observable<TypeOperationResponse> updateType(@PathVariable("id") Long id, @RequestBody TypeOperationRequest typeOperationRequest) {
        log.info("Actualizacion Tipo de operacion ");
        return operationService.updateType(id, typeOperationRequest);
    }
    
}