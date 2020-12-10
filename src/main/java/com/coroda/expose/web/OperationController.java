package com.coroda.expose.web;

import com.coroda.mcoperation.bussines.OperationService;
import com.coroda.mcoperation.model.api.request.Request;
import com.coroda.mcoperation.model.api.request.TypeOperationRequest;
import com.coroda.mcoperation.model.api.response.Response;
import com.coroda.mcoperation.model.api.response.TypeOperationResponse;
import com.coroda.mcoperation.util.Constants;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Completable saveretrofit(@RequestBody Request request) {
        log.info("Envio de parametros");
        return operationService.save(request);
    }

    @DeleteMapping(Constants.ID)
    @ApiOperation(value = Constants.DELETE_ID_VALUE, notes = Constants.DELETE_ID_NOTE)
    public Completable delete(@PathVariable("id") Long operationId) {
        log.info("Eliminar datos por id");
        return operationService.delete(operationId);
    }

    @PutMapping(Constants.ID)
    @ApiOperation(value = Constants.UPDATE_ID_VALUE, notes = Constants.UPDATE_ID_NOTE)
    public Completable update(@RequestBody Request request) {
        log.info("Actualizacion de parametros");
        return operationService.update(request);
    }

    @GetMapping(Constants.ID)
    @ApiOperation(value = Constants.GET_ID_VALUE, notes = Constants.GET_ID_NOTE)
    public Observable<Response> getById(@PathVariable("id") Long operationId) {
        log.info("Obtencion de datos por id");
        return operationService.getById(operationId);
    }

    @GetMapping
    @ApiOperation(value = Constants.GETDATA_VALUE, notes = Constants.GETDATA_NOTE)
    public Observable<Response> getData(@RequestParam Map<String, String> params) {
        log.info("Enviando parametros de busqueda");
        log.info("params "+params);
        return operationService.getData(params);
    }

    @PutMapping(Constants.TYPE)
    @ApiOperation(value = Constants.UPDATE_TYPEOPERATION_VALUE, notes = Constants.UPDATE_TYPEOPERATION_NOTE)
    public Observable<TypeOperationResponse> updateType(@PathVariable("id") Long id, @RequestBody TypeOperationRequest typeOperationRequest) {
        log.info("Actualizacion Tipo de operacion ");
        return operationService.updateType(id, typeOperationRequest);
    }

}