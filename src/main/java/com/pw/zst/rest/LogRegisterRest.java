package com.pw.zst.rest;

import com.pw.zst.DTO.LogRegisterDTO;
import com.pw.zst.repositories.LogRegisterRepository;
import com.pw.zst.service.LogRegisterService;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by arade on 25-Oct-15.
 */
@Path("/logRegister")
public class LogRegisterRest {

    @Inject
    LogRegisterService logRegisterService;

    @POST
    @Consumes("application/json")
    public void addLogRegister(LogRegisterDTO logRegisterDTO){
        logRegisterService.save(logRegisterDTO);
    }

    @GET
    @Produces("application/json")
    public List<LogRegisterDTO> findAll(){
        return logRegisterService.findAll();
    }
}
