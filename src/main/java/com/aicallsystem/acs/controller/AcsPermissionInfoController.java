package com.aicallsystem.acs.controller;


import com.aicallsystem.acs.common.ResultBean;
import com.aicallsystem.acs.entity.dto.permission.GetPermissionDTO;
import com.aicallsystem.acs.entity.dto.user.MarkUserDto;
import com.aicallsystem.acs.exception.SysException;
import com.aicallsystem.acs.service.IAcsPermissionInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.aicallsystem.acs.common.BaseController;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
@Api(tags = "用户权限 API")
@RestController
@RequestMapping("/permission")
public class AcsPermissionInfoController extends BaseController {

    @Autowired
    private IAcsPermissionInfoService iAcsPermissionInfoService;

    /**
     * <p>
     *      获取用户权限
     * </p>
     * @since 4/3/2019
     */
    @PostMapping("/getPermission")
    @ApiOperation("获取用户权限接口")
    public ResultBean<GetPermissionDTO> getPermission(){

        try{
            MarkUserDto userMark = getUserMark();
            GetPermissionDTO permissionList = iAcsPermissionInfoService.getPermission(userMark);
            return successResponse(permissionList,"获取用户权限成功");
        }catch (SysException e){
            return failResponse(e);
        }
    }

}
