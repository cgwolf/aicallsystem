package com.aicallsystem.acs.entity.dto.consumer;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 *      获取客户列表信息DTO
 * </p>
 * @author ispong
 * @since 5/4/2019
 * @version 1.0.0
 */
@Data
public class ListConsumerInfoDTO {

    @ApiModelProperty(value = "客户id")
    private Integer id;

    @ApiModelProperty(value = "客户姓名")
    private String name;

    @ApiModelProperty(value = "客户性别")
    private String sex;

    @ApiModelProperty(value = "客户电话 ")
    private String phone;

    @ApiModelProperty(value = "通话状态")
    private String stateString;

    @ApiModelProperty(value = "客户意向等级")
    private String rankString;

    @ApiModelProperty(value = "通话时长")
    private Integer callTime;

    @ApiModelProperty(value = "呼叫次数")
    private Integer callNum;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "批次号")
    private String batch;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "最后跟进时间")
    private LocalDateTime updateDate;

}
