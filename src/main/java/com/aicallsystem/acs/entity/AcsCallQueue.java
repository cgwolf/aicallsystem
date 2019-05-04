package com.aicallsystem.acs.entity;

import java.time.LocalDateTime;
import com.aicallsystem.acs.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 呼叫队列表
 * </p>
 *
 * @author ispong
 * @since 2019-05-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="AcsCallQueue对象", description="呼叫队列表")
public class AcsCallQueue extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "客户id")
    private Integer consumerId;

    @ApiModelProperty(value = "任务id")
    private Integer taskId;

    @ApiModelProperty(value = "模板id")
    private Integer templateId;

    @ApiModelProperty(value = "类别")
    private String type;

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "跟进时间")
    private LocalDateTime updateDate;


}
