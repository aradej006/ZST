package com.pw.zst;

import com.pw.zst.DTO.*;
import com.pw.zst.entities.LogAttribute;
import com.pw.zst.entities.LogAttributeName;
import com.pw.zst.entities.LogEntity;
import com.pw.zst.service.LogEntityService;
import com.pw.zst.service.LogRegisterService;
import com.pw.zst.service.LogTypeService;
import com.pw.zst.translators.LogEntityTranslator;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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

    @Inject
    LogEntityService logEntityService;

    @PostConstruct
    void init(){
        initLogRegistryService();
        initLogTypeService();
        initLogEntity();
    }

    private void initLogRegistryService(){
        LogRegisterDTO logRegisterDTO = new LogRegisterDTO();
        logRegisterDTO.setName("Register1");
        List<LogAttributeNameDTO> logAttributeNameDTOs = new LinkedList<LogAttributeNameDTO>();
        LogAttributeNameDTO logAttributeNameDTO1 = new LogAttributeNameDTO();
        LogAttributeNameDTO logAttributeNameDTO2 = new LogAttributeNameDTO();
        logAttributeNameDTO1.setName("Message");
        logAttributeNameDTO2.setName("Details");
        logAttributeNameDTOs.add(logAttributeNameDTO1);
        logAttributeNameDTOs.add(logAttributeNameDTO2);
        logRegisterDTO.setLogAttributeNameDTOs(logAttributeNameDTOs);
        System.out.println(logRegisterDTO);
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

    private void initLogEntity(){
        LogEntityDTO logEntityDTO = new LogEntityDTO();
        logEntityDTO.setSourceId(122121212L);
        logEntityDTO.setLogDate(new Date());
        logEntityDTO.setLogRegisterDTO(logRegisterService.findByName("Register1").get(0));
        logEntityDTO.setLogTypeDTO(logTypeService.findAll().get(0));
        LogAttributeDTO logAttributeDTO1 = new LogAttributeDTO();
        logAttributeDTO1.setValue("attribute1");
        LogAttributeDTO logAttributeDTO2 = new LogAttributeDTO();
        logAttributeDTO2.setValue("attribute2");
        List<LogAttributeDTO> logAttributeDTOs = new LinkedList<LogAttributeDTO>();
        logAttributeDTOs.add(logAttributeDTO1);
        logAttributeDTOs.add(logAttributeDTO2);
        logEntityDTO.setLogAttributeDTOs(logAttributeDTOs);
        logEntityService.save(logEntityDTO);

//        LogEntityDTO logEntityDTO1 = new LogEntityDTO();
        logEntityDTO.setSourceId(122121212L);
        logEntityDTO.setLogDate(new Date());
        logEntityDTO.setLogRegisterDTO(logRegisterService.findByName("Register1").get(0));
        logEntityDTO.setLogTypeDTO(logTypeService.findAll().get(1));
//        LogAttributeDTO logAttributeDTO1 = new LogAttributeDTO();
        logAttributeDTO1.setValue("attribute3");
//        LogAttributeDTO logAttributeDTO2 = new LogAttributeDTO();
        logAttributeDTO2.setValue("attribute4");
//        List<LogAttributeDTO> logAttributeDTOs = new LinkedList<LogAttributeDTO>();
        logAttributeDTOs.clear();
        logAttributeDTOs.add(logAttributeDTO1);
        logAttributeDTOs.add(logAttributeDTO2);
        logEntityDTO.setLogAttributeDTOs(logAttributeDTOs);
        logEntityService.save(logEntityDTO);

    }

}
