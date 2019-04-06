package com.aicallsystem.acs.controller;


import com.aicallsystem.acs.common.PageHelperModel;
import com.aicallsystem.acs.common.ResultBean;
import com.aicallsystem.acs.entity.AcsContactInfo;
import com.aicallsystem.acs.service.IAcsContactInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.aicallsystem.acs.common.BaseController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * <p>
 *      联系我们信息 前端控制器
 * </p>
 *
 * @author ispong
 * @since 2019-04-03
 */
@RestController
@RequestMapping("/contact")
@Api(tags = "联系信息 API")
public class AcsContactInfoController extends BaseController {

    @Autowired
    private IAcsContactInfoService iAcsContactInfoService;

    /**
     * <p>
     *      查询联系信息
     * </p>
     * @param pageHelperModel
     * @since 4/3/2019
     */
    @PostMapping("/listContact")
    @ApiOperation("查询联系信息")
    public ResultBean<AcsContactInfo> listContact(@RequestBody PageHelperModel pageHelperModel){

        PageHelper.startPage(pageHelperModel.getPage() , pageHelperModel.getSize());
        List<AcsContactInfo> listContact = iAcsContactInfoService.list();
        PageInfo<AcsContactInfo> listContactPageInfo= new PageInfo(listContact);

        List<AcsContactInfo> contactInfos = listContactPageInfo.getList();
        long total = listContactPageInfo.getTotal();

        Map map = new HashMap(2);
        map.put("contactInfos",contactInfos);
        map.put("total", total);

//        copyProperties();

        return successResponse(map,"获取联系信息列表成功");
    }

}
