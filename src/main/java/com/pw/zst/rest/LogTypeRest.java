package com.pw.zst.rest;

import com.pw.zst.DTO.LogTypeDTO;
import com.pw.zst.service.LogTypeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by arade on 25-Oct-15.
 */
@Path("/logType")
public class LogTypeRest {

    @Inject
    private LogTypeService logTypeService;

    @POST
    @Consumes("application/json")
    public void addLogType(LogTypeDTO logTypeDTO){
        logTypeService.save(logTypeDTO);
    }

    @GET
    @Produces("application/json")
    public List<LogTypeDTO> getAllTypes(){
        return logTypeService.findAll();
    }
}
