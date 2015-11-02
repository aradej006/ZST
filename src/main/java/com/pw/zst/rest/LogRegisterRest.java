package com.pw.zst.rest;

import com.pw.zst.DTO.LogRegisterDTO;
import com.pw.zst.service.LogRegisterService;

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
@Path("/logRegister")
public class LogRegisterRest {

    @Inject
    LogRegisterService logRegisterService;

    @POST
    @Consumes("application/json")
    public Response addLogRegister(LogRegisterDTO logRegisterDTO){
        try{
            logRegisterService.save(logRegisterDTO);
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
    public List<LogRegisterDTO> findAll(){
        return logRegisterService.findAll();
    }
}
