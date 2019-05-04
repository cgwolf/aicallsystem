package com.aicallsystem.acs.mapper;

import com.aicallsystem.acs.entity.AcsConsumerInfo;
import com.aicallsystem.acs.entity.dto.consumer.ConsConditionDTO;
import com.aicallsystem.acs.entity.dto.consumer.ListConsumerInfoDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 客户表 Mapper 接口
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
@Mapper
@Component
public interface AcsConsumerInfoMapper extends BaseMapper<AcsConsumerInfo> {

    /**
     * <p>
     *     查询客户信息
     * </p>
     * @param
     * @return
     * @throws
     * @since 5/4/2019
     */
    List<ListConsumerInfoDTO> listConsumer(@Param("userUuid") String userUUid,@Param("consCondition") ConsConditionDTO consConditionDTO);

    /**
     * <p>
     *     添加客户信息
     * </p>
     * @param
     * @return
     * @throws
     * @since 5/4/2019
     */
    void addConsumer(AcsConsumerInfo acsConsumerInfo);
}

