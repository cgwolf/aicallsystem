package com.aicallsystem.acs.entity.dto.contact;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *      删除联系方式VO
 * </p>
 * @author ispong
 * @since 4/7/2019
 * @version 1.0.0
 */
@Data
@ApiModel(description="标记联系对象")
public class MarkContactDTO {

    @ApiModelProperty("联系方式id")
    private Integer id;
}
