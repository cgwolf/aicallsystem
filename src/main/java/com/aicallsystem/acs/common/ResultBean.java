package com.aicallsystem.acs.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 *   返回对象
 * </p>
 * @author ispong
 * @version 1.0.0
 */
@Data
@AllArgsConstructor
public class ResultBean<T> {

    private static final long serialVersionUID = 1L;

    // true, false
    private boolean status;

    // 包含成功或失败信息
    private String description;

    // 详细数
    private T data;

}
