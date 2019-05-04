package com.aicallsystem.acs.entity.dto.consumer;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 *      查询条件
 * </p>
 * @author ispong
 * @since 5/4/2019
 * @version 1.0.0
 */
@Data
public class ConsConditionDTO {

    @ApiModelProperty(value = "通话等级")
    private List<String> rank;

    @ApiModelProperty(value = "意向等级")
    private List<String> state;
}
