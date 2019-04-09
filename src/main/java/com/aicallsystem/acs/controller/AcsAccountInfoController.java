package com.aicallsystem.acs.controller;

import com.aicallsystem.acs.common.ResultBean;
import com.aicallsystem.acs.entity.dto.account.CreateAccountDTO;
import com.aicallsystem.acs.entity.dto.account.UserAuthDTO;
import com.aicallsystem.acs.entity.dto.token.MarkTokenDto;
import com.aicallsystem.acs.exception.SysException;
import com.aicallsystem.acs.exception.SysExceptionEnum;
import com.aicallsystem.acs.service.IAcsAccountInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.aicallsystem.acs.common.BaseController;

/**
 * <p>
 * 用户账号表 前端控制器
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
@Api(tags = "用户账号 API")
@RestController
@RequestMapping("/account")
public class AcsAccountInfoController extends BaseController {

    @Autowired
    private IAcsAccountInfoService iAcsAccountInfoService;

    /**
     * <p>
     *     用户验证接口
     * </p>
     * @param userAuthDto 用户账号对象
     * @since 4/3/2019
     */
    @PostMapping("/userAuth")
    @ApiOperation("用户身份验证接口")
    public ResultBean<MarkTokenDto> userAuth(@RequestBody UserAuthDTO userAuthDto){

        try{
            MarkTokenDto markTokenDto = iAcsAccountInfoService.userAuth(userAuthDto);
            return successResponse(markTokenDto,"身份验证成功");
        }catch (SysException e){
            return failResponse(e);
        }

    }

    /**
     * <p>
     *     账号创建接口
     * </p>
     * @param
     * @return
     * @throws
     * @since 4/3/2019
     */
    @PostMapping("/createAccount")
    @ApiOperation("账号创建接口")
    public ResultBean createAccount(@RequestBody CreateAccountDTO createAccountDTO){

        try{
            MarkTokenDto token = iAcsAccountInfoService.createAccount(createAccountDTO);
            return successResponse(token,"创建账号成功");
        }catch (SysException e){
            return failResponse(e);
        }

    }



}
