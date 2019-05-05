package com.aicallsystem.acs.entity.dto.consumer;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 *      删除客户信息DTO
 * </p>
 * @author ispong
 * @since 5/5/2019
 * @version 1.0.0
 */
@Data
public class DeleteConsumerDTO {

    @ApiModelProperty("客户信息id集合")
    List<Integer> consumerList;
}
