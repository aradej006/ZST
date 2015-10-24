package com.pw.zst.service;

import com.pw.zst.DTO.LogEntityDTO;
import com.pw.zst.repositories.LogEntityRepository;
import com.pw.zst.translators.LogEntityTranslator;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by arade on 24-Oct-15.
 */
@Path("/log")
public class LogAgent {

    @Inject
    LogEntityRepository logEntityRepository;

    @PostConstruct
    public void init(){
        logEntityRepository.toString();
    }

    @POST
    @Consumes("application/json")
    public Response saveLog(LogEntityDTO logEntityDTO){
        try{
            logEntityRepository.save(LogEntityTranslator.toEntity(logEntityDTO));
        }catch(ConstraintViolationException e){
            Map<String, String> responseObj = new HashMap<String, String>();
            responseObj.put("error", e.getMessage());
            System.out.println(e.getConstraintViolations());
            return Response.status(Response.Status.BAD_REQUEST).entity(responseObj).build();
        }
        return Response.status(201).build();
    }

}
