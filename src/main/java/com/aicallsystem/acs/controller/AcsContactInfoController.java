package com.aicallsystem.acs.controller;


import com.aicallsystem.acs.common.PageHelper;
import com.aicallsystem.acs.entity.AcsContactInfo;
import com.aicallsystem.acs.entity.AcsTest;
import com.aicallsystem.acs.service.IAcsContactInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.aicallsystem.acs.common.BaseController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 联系我们信息 前端控制器
 * </p>
 *
 * @author ispong
 * @since 2019-04-03
 */
@RestController
@RequestMapping("/contact")
public class AcsContactInfoController extends BaseController {

    @Autowired
    private IAcsContactInfoService iAcsContactInfoService;

    /**
     * <p>
     *      查询联系信息
     * </p>
     * @param pageHelper
     * @since 4/3/2019
     */
    public ResponseEntity listContact(@RequestBody PageHelper pageHelper){


        com.github.pagehelper.PageHelper.startPage(pageHelper.getPage() ,pageHelper.getSize());

        List<AcsContactInfo> listContact = iAcsContactInfoService.list();

        PageInfo<AcsContactInfo> listContactPageInfo= new PageInfo(listContact);
        List<AcsContactInfo> contactInfos = listContactPageInfo.getList();
        long total = listContactPageInfo.getTotal();

        Map map = new HashMap(2);
        map.put("contactInfos",contactInfos);
        map.put("total", total);

//        return successResponse(map,"获取联系信息列表成功");
        return null;
    }

}
