package com.pw.zst;

import com.pw.zst.DTO.LogRegisterDTO;
import com.pw.zst.DTO.LogTypeDTO;
import com.pw.zst.service.LogRegisterService;
import com.pw.zst.service.LogTypeService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Created by arade on 26-Oct-15.
 */
@Singleton
@Startup
public class StartupBean {

    @Inject
    LogRegisterService logRegisterService;

    @Inject
    LogTypeService logTypeService;

    @PostConstruct
    void init(){
        initLogRegistryService();
        initLogTypeService();
    }

    private void initLogRegistryService(){
        LogRegisterDTO logRegisterDTO = new LogRegisterDTO();
        logRegisterDTO.setRegisterName("Register1");
        logRegisterDTO.setAttributesQuantity(3);
        logRegisterService.save(logRegisterDTO);
    }

    private void initLogTypeService(){
        LogTypeDTO logTypeDTO1 = new LogTypeDTO();
        LogTypeDTO logTypeDTO2= new LogTypeDTO();
        LogTypeDTO logTypeDTO3 = new LogTypeDTO();
        logTypeDTO1.setLogType("INFO");
        logTypeDTO2.setLogType("ERROR");
        logTypeDTO3.setLogType("WARN");
        logTypeService.save(logTypeDTO1);
        logTypeService.save(logTypeDTO2);
        logTypeService.save(logTypeDTO3);
    }
}
