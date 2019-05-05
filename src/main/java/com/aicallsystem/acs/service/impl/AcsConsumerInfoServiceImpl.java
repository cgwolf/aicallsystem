package com.aicallsystem.acs.service.impl;

import com.aicallsystem.acs.entity.AcsConsumerInfo;
import com.aicallsystem.acs.entity.dto.consumer.AddConsumerDTO;
import com.aicallsystem.acs.entity.dto.consumer.ConsConditionDTO;
import com.aicallsystem.acs.entity.dto.consumer.DeleteConsumerDTO;
import com.aicallsystem.acs.entity.dto.consumer.ListConsumerInfoDTO;
import com.aicallsystem.acs.entity.dto.user.MarkUserDto;
import com.aicallsystem.acs.exception.SysException;
import com.aicallsystem.acs.exception.SysExceptionEnum;
import com.aicallsystem.acs.mapper.AcsConsumerInfoMapper;
import com.aicallsystem.acs.service.IAcsConsumerInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * <p>
 * 客户表 服务实现类
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
@Service
public class AcsConsumerInfoServiceImpl extends ServiceImpl<AcsConsumerInfoMapper, AcsConsumerInfo> implements IAcsConsumerInfoService {

    @Autowired
    private AcsConsumerInfoMapper acsConsumerInfoMapper;

    @Override
    public List<ListConsumerInfoDTO> listConsumer(ConsConditionDTO consConditionDTO, MarkUserDto markUserDto) {

        List<ListConsumerInfoDTO> listConsumer = acsConsumerInfoMapper.listConsumer(markUserDto.getUserUuid(),consConditionDTO);

        return listConsumer;
    }

    @Override
    public void addConsumer(AddConsumerDTO addConsumerDTO, MarkUserDto markUserDto) {

        AcsConsumerInfo acsConsumerInfo = new AcsConsumerInfo();
        copyProperties(addConsumerDTO,acsConsumerInfo);
        acsConsumerInfo.setUserUuid(markUserDto.getUserUuid());
        try {
            acsConsumerInfoMapper.addConsumer(acsConsumerInfo);
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException(SysExceptionEnum.DAO_ERROR);
        }
    }

    @Override
    public void addConsumerList(List<AcsConsumerInfo> consumerInfos) {

        for(AcsConsumerInfo consumerInfo:consumerInfos){
            acsConsumerInfoMapper.addConsumer(consumerInfo);
        }

    }

    @Override
    public void deleteConsumer(DeleteConsumerDTO deleteConsumerDTO, MarkUserDto markUserDto) {


        List<Integer> consumerList = deleteConsumerDTO.getConsumerList();

        for(Integer consumerId :consumerList){
            acsConsumerInfoMapper.deleteConsumer(markUserDto.getUserUuid(),consumerId);
        }

    }
}
