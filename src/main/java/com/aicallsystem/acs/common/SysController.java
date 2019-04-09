package com.aicallsystem.acs.common;

import com.aicallsystem.acs.exception.SysException;
import com.aicallsystem.acs.exception.SysExceptionEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *      系统错误页面
 * </p>
 * @author ispong
 * @since 4/9/2019
 * @version 1.0.0
 */
@RestController
@RequestMapping("/sys")
public class SysController extends BaseController{

    @RequestMapping("/tokenError")
    public ResultBean tokenError(){

        return failResponse(new SysException(SysExceptionEnum.TOKEN_ERROR));
    }
}
