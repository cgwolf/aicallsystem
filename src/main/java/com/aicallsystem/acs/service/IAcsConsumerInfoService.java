package com.aicallsystem.acs.service;

import com.aicallsystem.acs.entity.AcsConsumerInfo;
import com.aicallsystem.acs.entity.dto.consumer.AddConsumerDTO;
import com.aicallsystem.acs.entity.dto.consumer.ConsConditionDTO;
import com.aicallsystem.acs.entity.dto.consumer.DeleteConsumerDTO;
import com.aicallsystem.acs.entity.dto.consumer.ListConsumerInfoDTO;
import com.aicallsystem.acs.entity.dto.user.MarkUserDto;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 客户表 服务类
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
public interface IAcsConsumerInfoService extends IService<AcsConsumerInfo> {

    List<ListConsumerInfoDTO> listConsumer(ConsConditionDTO consConditionDTO, MarkUserDto markUserDto);

    void addConsumer(AddConsumerDTO addConsumerDTO,MarkUserDto markUserDto);

    void addConsumerList(List<AcsConsumerInfo> consumerInfos);

    void deleteConsumer(DeleteConsumerDTO deleteConsumerDTO,MarkUserDto markUserDto);
}
