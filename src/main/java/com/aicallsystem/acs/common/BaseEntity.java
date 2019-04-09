package com.aicallsystem.acs.common;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;


/**
 * <p>
 *      entity基础配置
 * </p>
 * @author ispong
 * @since 4/3/2019
 * @version 1.0.0
 */
@Data
public class BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId
    private int id;

    @TableId
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;
}
