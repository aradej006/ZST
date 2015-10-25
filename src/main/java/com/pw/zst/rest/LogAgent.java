package com.pw.zst.rest;

import com.pw.zst.DTO.LogEntityDTO;
import com.pw.zst.service.LogEntityService;
import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by arade on 24-Oct-15.
 */
@Path("/log")
public class LogAgent {

    @Inject
    LogEntityService logEntityService;


    @POST
    @Consumes("application/json")
    public Response saveLog(LogEntityDTO logEntityDTO){
        try{
            logEntityService.save(logEntityDTO);
        }catch(ConstraintViolationException e){
            Map<String, String> responseObj = new HashMap<String, String>();
            responseObj.put("error", e.getMessage());
            System.out.println(e.getConstraintViolations());
            return Response.status(Response.Status.BAD_REQUEST).entity(responseObj).build();
        }
        return Response.status(201).build();
    }

    @Path("/all")
    @GET
    @Produces("application/json")
    public List<LogEntityDTO> findAll(){
        return logEntityService.findAll();
    }

}
