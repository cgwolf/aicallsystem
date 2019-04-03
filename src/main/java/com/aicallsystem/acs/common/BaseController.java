package com.aicallsystem.acs.common;

import com.aicallsystem.acs.exception.SysException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * <p>
 *      基础controller配置
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
     * @param
     * @return
     * @throws
     * @since 4/3/2019
     */
    public ResponseEntity successResponse(Object object,String description){

        ResultBean resultBean = new ResultBean("success", description, object);
        return new ResponseEntity(resultBean, HttpStatus.OK);
    }

    /**
     * <p>
     *     失败返回
     * </p>
     * @param
     * @return
     * @throws
     * @since 4/3/2019
     */
    public ResponseEntity failResponse(SysException sysException){

        ResultBean resultBean = new ResultBean("fail", sysException.getMsg(), "");
        return new ResponseEntity(resultBean, HttpStatus.OK);
    }


}
