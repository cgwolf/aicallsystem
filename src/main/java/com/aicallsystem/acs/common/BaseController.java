package com.aicallsystem.acs.common;

import com.aicallsystem.acs.exception.SysException;

/**
 * <p>
 *      controller基础配置
 * </p>
 * @author ispong
 * @since 4/3/2019
 * @version 1.0.0
 */
public class BaseController {

    /**
     * <p>
     *      成功返回
     * </p>
     * @param object 数据对象
     * @param description 返回描述
     * @since 4/3/2019
     */
    public ResultBean successResponse(Object object,String description){

        return new ResultBean(true, description, object);
    }

    /**
     * <p>
     *     失败返回
     * </p>
     * @param sysException 系统异常对象
     * @since 4/3/2019
     */
    public ResultBean failResponse(SysException sysException){

        return new ResultBean(false, sysException.getDescription(), "");
    }


}
