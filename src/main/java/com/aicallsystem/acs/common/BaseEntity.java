package com.aicallsystem.acs.common;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


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
}
