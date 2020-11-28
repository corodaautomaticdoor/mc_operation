package com.coroda.mcoperation.util;

public class Constants {

    public final static String MAIN_PATH = "/operacion";
    public final static String ID = "/{id}";
    public final static String TYPE = "/type/{id}";

    public final static String SUCCESS = "SUCCESS";
    public final static String ERROR = "ERROR";

    public final static String SAVE_VALUE="Metodo a traves del cual se envia la informacion de la  Operacion que  sera registrada dentro de la base de datos";
    public final static String SAVE_NOTE="Para el registro de la Operacion , sera necesario el llenado de todo los campos , a excepcion de los Id´s los cuales seran generados automaticamente";
    public final static String DELETE_ID_VALUE="Metodo a traves del cual se Elimina la informacion de la  Operacion mediante su Id ";
    public final static String DELETE_ID_NOTE="Para eliminar los  datos de una  Operacion , sera necesario enviar el Id de la Operacion ";
    public final static String UPDATE_ID_VALUE="Metodo a traves del cual se Actualiza la informacion de la  Operacion mediante su Id ";
    public final static String UPDATE_ID_NOTE="Para Actualizar los  datos de una  Operacion , sera necesario enviar todo el registro con los datos ya actualizados junto a sus Id`s ";
    public final static String GET_ID_VALUE="Metodo a traves del cual se Obtiene la informacion de la  Operacion mediante su Id ";
    public final static String GET_ID_NOTE="Para la obtencion de datos de una  Operacion , sera necesario enviar el Id de la Operacion a consultar";

    public final static String GETDATA_VALUE="Metodo a traves del cual se Obtiene la informacion de la  Operacion mediante el Tipo de Operacion y/o Cliente, ademas se puede obtener todas las operaciones registradas";
    public final static String GETDATA_NOTE="Para la obtencion de datos de la  Operacion , sera necesario enviar el Tipo de Operacion y/o Cliente a consultar; si no se envia ninguna variable te traera todas las cotizaciones";
    public final static String UPDATE_TYPEOPERATION_VALUE="Metodo a traves del cual se Actualizara el tipo de  Operacion";
    public final static String UPDATE_TYPEOPERATION_NOTE="Para Actualizar el tipo de  Operacion sera necesario el envio del ID y especificar que tipo de operacion sera";

    //RETROFIT
    public final static String URL_MCPRODUCT = "http://localhost:8021";
    public final static String URL_MCPERSON = "http://localhost:8022";
}