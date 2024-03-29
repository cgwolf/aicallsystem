package com.aicallsystem.acs.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *      pageHelper对象
 * </p>
 * @author ispong
 * @since 4/3/2019
 * @version 1.0.0
 */
@Data
public class PageHelperModel {

    @ApiModelProperty("分页页数")
    private int page;

    @ApiModelProperty("分页每页个数")
    private int size;

    @ApiModelProperty("分页排序条件 传递字段名")
    private String orderValue;

    @ApiModelProperty("分页排序方式 acs为增序/desc为降序")
    private String orderType;
}
