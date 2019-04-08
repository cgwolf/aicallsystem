package com.aicallsystem.acs.controller;

import com.aicallsystem.acs.common.BaseController;
import com.aicallsystem.acs.common.ResultBean;
import com.aicallsystem.acs.entity.AcsAccountInfo;
import com.aicallsystem.acs.entity.AcsTokenInfo;
import com.aicallsystem.acs.exception.SysException;
import com.aicallsystem.acs.exception.SysExceptionEnum;
import com.aicallsystem.acs.service.IAcsTokenInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *      用户信息
 * </p>
 * @author ispong
 * @since 4/3/2019
 * @version 1.0.0
 */
@Api(tags = "身份验证 API")
@RestController
public class AcsAuthController extends BaseController {

    @Autowired
    private IAcsTokenInfoService iAcsTokenInfoService;

    /**
     * <p>
     *     用户验证接口
     * </p>
     * @param
     * @return
     * @throws
     * @since 4/3/2019
     */
    @PostMapping("/userManage/login")
    @ApiOperation("用户身份验证接口")
    public ResultBean<AcsTokenInfo> userAuth(@RequestBody AcsAccountInfo acsAccountInfo){


        if("admin".equals(acsAccountInfo.getUserName())&&"88888888".equals(acsAccountInfo.getPassword())){

            String token = iAcsTokenInfoService.tokenGenerator(acsAccountInfo);

            AcsTokenInfo acsTokenInfo = new AcsTokenInfo(token);

            return successResponse(acsTokenInfo,"成功");
        }

        return failResponse(new SysException(SysExceptionEnum.AUTH_ERROR));
    }

}
