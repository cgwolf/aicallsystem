package com.aicallsystem.acs.controller;

import com.aicallsystem.acs.common.BaseController;
import com.aicallsystem.acs.common.ResultBean;
import com.aicallsystem.acs.entity.AcsAccountInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@Api(tags = "Auth API")
@RestController
public class AcsAuthController extends BaseController {

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
    public ResponseEntity userAuth(@RequestBody AcsAccountInfo acsAccountInfo){


        if("admin".equals(acsAccountInfo.getUserName())&&"88888888".equals(acsAccountInfo.getPassword())){

            return successResponse("","成功");
        }

        return new ResponseEntity(new ResultBean(false, "失败", ""), HttpStatus.OK);
    }

}
