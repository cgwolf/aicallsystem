package com.aicallsystem.acs.entity;

import com.aicallsystem.acs.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据库测试
 * </p>
 *
 * @author ispong
 * @since 2019-04-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="AcsTest对象", description="数据库测试")
public class AcsTest extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "内容")
    private String content;

}
