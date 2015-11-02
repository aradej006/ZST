package com.pw.zst.rest;

import com.pw.zst.DTO.LogTypeDTO;
import com.pw.zst.service.LogTypeService;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by arade on 25-Oct-15.
 */
@Path("/logType")
public class LogTypeRest {

    @Inject
    private LogTypeService logTypeService;

    @POST
    @Consumes("application/json")
    public Response addLogType(LogTypeDTO logTypeDTO){
        try{
            logTypeService.save(logTypeDTO);
        }catch(ConstraintViolationException e){
            Map<String, String> responseObj = new HashMap<String, String>();
            responseObj.put("error", e.getMessage());
            System.out.println(e.getConstraintViolations());
            return Response.status(Response.Status.BAD_REQUEST).entity(responseObj).build();
        }
        return Response.status(201).build();
    }

    @GET
    @Produces("application/json")
    public List<LogTypeDTO> getAllTypes(){
        return logTypeService.findAll();
    }
}
