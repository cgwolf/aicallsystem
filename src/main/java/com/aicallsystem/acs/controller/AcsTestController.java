package com.aicallsystem.acs.controller;

import com.aicallsystem.acs.common.ResultBean;
import com.aicallsystem.acs.entity.AcsTest;
import com.aicallsystem.acs.service.IAcsTestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aicallsystem.acs.common.BaseController;

import java.util.List;

/**
 * <p>
 * 数据库测试 前端控制器
 * </p>
 *
 * @author ispong
 * @since 2019-04-03
 */
@Api(tags = "测试 API")
@RestController
@RequestMapping("/test")
public class AcsTestController extends BaseController {

    @Autowired
    private IAcsTestService iAcsTestService;

    /**
     * <p>
     *     测试类列表
     * </p>
     * @since 4/3/2019
     */
    @ApiOperation(value = "测试类列表")
    @PostMapping("/listTest")
    public ResultBean listTest(){

        PageHelper.startPage(1 ,10);

        List<AcsTest> listTest = iAcsTestService.list();

        PageInfo<AcsTest> pageListDtoPageInfo= new PageInfo(listTest);
        List<AcsTest> testList = pageListDtoPageInfo.getList();

        return successResponse(testList,"获取测试列表成功");
    }

}
