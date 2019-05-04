package com.aicallsystem.acs.controller;

import com.aicallsystem.acs.common.ResultBean;
import com.aicallsystem.acs.entity.AcsConsumerInfo;
import com.aicallsystem.acs.entity.dto.consumer.AddConsumerDTO;
import com.aicallsystem.acs.entity.dto.consumer.ConsConditionDTO;
import com.aicallsystem.acs.entity.dto.consumer.ListConsumerInfoDTO;
import com.aicallsystem.acs.exception.SysException;
import com.aicallsystem.acs.service.IAcsConsumerInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IAcsConsumerInfoService iAcsConsumerInfoService;

    @ApiOperation(value = "查询客户信息接口")
    @PostMapping("listConsumer")
    public ResultBean<ListConsumerInfoDTO> listConsumer(@RequestBody ConsConditionDTO consConditionDTO){


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
    public ResultBean addConsumer(@RequestBody AddConsumerDTO addConsumerDTO){

        try {
            iAcsConsumerInfoService.addConsumer(addConsumerDTO,getUserMark());
            return successResponse("", "客户信息添加成功");
        }catch (SysException e){
            return failResponse(e);
        }
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
    @PostMapping("uploadConsumer")
    public ResultBean uploadConsumer(@ApiParam(value = "上传的文件") @RequestPart(value = "file") MultipartFile multipartFile,
                                     @ApiParam(value = "批次号") @RequestParam(value = "batch" ,required = false) String batch,
                                     @ApiParam(value = "是否加入呼叫") @RequestParam(value = "isCall" ,required = false) String isCall){
        try {

            List<AcsConsumerInfo> consumerInfos = uploadConsumerUtil(multipartFile, batch,getUserMark());
            iAcsConsumerInfoService.addConsumerList(consumerInfos);

            return successResponse("","接受成功");
        }catch (SysException e){

            return failResponse(e);
        }

    }


}
