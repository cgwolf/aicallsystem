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
 * 客户表
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="AcsConsumerInfo对象", description="客户表")
public class AcsConsumerInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "客户姓名")
    private String name;

    @ApiModelProperty(value = "客户性别")
    private String sex;

    @ApiModelProperty(value = "客户手机号 ")
    private String phone;

    @ApiModelProperty(value = "客户其他电话")
    private String otherPhone;

    @ApiModelProperty(value = "客户公司")
    private String company;

    @ApiModelProperty(value = "跟进时间")
    private LocalDateTime updateDate;

    @ApiModelProperty(value = "隶属")
    private String part;

    @ApiModelProperty(value = "客户导入类型")
    private String typeString;

    @ApiModelProperty(value = "跟进内容")
    private String updateContent;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "批次号")
    private String batch;

    @ApiModelProperty(value = "用户的uuid")
    private String userUuid;

}
