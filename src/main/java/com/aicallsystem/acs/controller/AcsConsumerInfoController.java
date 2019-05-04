package com.aicallsystem.acs.controller;

import com.aicallsystem.acs.common.ResultBean;
import com.aicallsystem.acs.entity.AcsConsumerInfo;
import com.aicallsystem.acs.exception.SysException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import com.aicallsystem.acs.common.BaseController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.aicallsystem.acs.util.UploadExcelUtil.uploadConsumerUtil;

/**
 * <p>
 * 客户表 前端控制器
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
@Api(tags = "客户模块 API")
@RestController
@RequestMapping("/consumer")
public class AcsConsumerInfoController extends BaseController {

    @ApiOperation(value = "客户加入呼叫接口")
    @PostMapping("listConsumer")
    public ResultBean listConsumer(){
        // 每个用户都有自己的不同的客户，通过token获取用户的uuid
        return null;
    }

    @ApiOperation(value = "客户信息删除接口")
    @PostMapping("deleteConsumer")
    public ResultBean deleteConsumer(){
        // 每个用户都有自己的不同的客户，通过token获取用户的uuid
        return null;
    }

    @ApiOperation(value = "客户信息添加接口")
    @PostMapping("addConsumer")
    public ResultBean addConsumer(){
        // 每个用户都有自己的不同的客户，通过token获取用户的uuid
        return null;
    }


    /**
     * <p>
     *     上传客户信息文件
     * </p>
     * @param
     * @return
     * @throws
     * @since 5/4/2019
     */
    @ApiOperation(value = "上传客户信息文件接口")
    @PostMapping("uploadConsumerInfo")
    public ResultBean uploadConsumerInfo(@RequestPart(value = "file") MultipartFile multipartFile,
                                         @RequestParam(value = "batch" ,required = false) String batch,
                                         @RequestParam(value = "isCall" ,required = false) String isCall){
        try {

            List<AcsConsumerInfo> consumerInfos = uploadConsumerUtil(multipartFile, batch,getUserMark());


            return successResponse("","接受成功");
        }catch (SysException e){

            return failResponse(e);
        }

    }


}
