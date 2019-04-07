package com.aicallsystem.acs.entity.VO;

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
public class DeleteContactVO {

    @ApiModelProperty("联系方式id")
    private int id;
}
