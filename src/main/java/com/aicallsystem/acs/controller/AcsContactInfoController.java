package com.aicallsystem.acs.controller;


import com.aicallsystem.acs.common.PageHelperModel;
import com.aicallsystem.acs.common.ResultBean;
import com.aicallsystem.acs.entity.AcsContactInfo;
import com.aicallsystem.acs.entity.VO.AddContactVO;
import com.aicallsystem.acs.entity.VO.DeleteContactVO;
import com.aicallsystem.acs.entity.VO.ListContactVO;
import com.aicallsystem.acs.exception.SysException;
import com.aicallsystem.acs.exception.SysExceptionEnum;
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

import java.util.List;

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
    public ResultBean<ListContactVO> listContact(@RequestBody PageHelperModel pageHelperModel){

        PageHelper.startPage(pageHelperModel.getPage() , pageHelperModel.getSize());
        List<AcsContactInfo> listContact = iAcsContactInfoService.list();
        PageInfo<AcsContactInfo> listContactPageInfo= new PageInfo(listContact);

        List<AcsContactInfo> contactInfos = listContactPageInfo.getList();
        long total = listContactPageInfo.getTotal();

        ListContactVO listContactVO = new ListContactVO();

        listContactVO.setAcsContactInfos(contactInfos);
        listContactVO.setTotal(total);

        return successResponse(listContactVO,"获取联系信息列表成功");
    }


    /**
     * <p>
     *      添加联系方式
     * </p>
     * @param addContactVO 联系方式对象
     * @since 4/3/2019
     */
    @PostMapping("/addContact")
    @ApiOperation("添加联系信息")
    public ResultBean addContact(@RequestBody AddContactVO addContactVO){

        AcsContactInfo acsContactInfo = new AcsContactInfo();
        try{
            copyProperties(addContactVO,acsContactInfo);
            iAcsContactInfoService.addContact(acsContactInfo);
        }catch (Exception e){
            e.printStackTrace();
            return failResponse(new SysException(SysExceptionEnum.ADD_CONTACT_ERROR));
        }

        return successResponse("","添加联系方式成功");
    }

    /**
     * <p>
     *      删除联系方式
     * </p>
     * @param deleteContactVO 联系方式id
     * @since 4/3/2019
     */
    @PostMapping("/deleteContact")
    @ApiOperation("删除联系信息")
    public ResultBean deleteContact(@RequestBody DeleteContactVO deleteContactVO){

        AcsContactInfo acsContactInfo = new AcsContactInfo();
        try{
            copyProperties(deleteContactVO,acsContactInfo);
            iAcsContactInfoService.deleteContact(acsContactInfo);
        }catch (Exception e){
            e.printStackTrace();
            return failResponse(new SysException(SysExceptionEnum.DELETE_CONTACT_ERROR));
        }

        return successResponse("","删除联系方式成功");
    }


    /**
     * <p>
     *      更新联系方式状态
     * </p>
     * @param deleteContactVO 联系方式id
     * @since 4/3/2019
     */
    @PostMapping("/updateContactState")
    @ApiOperation("更新联系方式状态")
    public ResultBean updateContactState(@RequestBody DeleteContactVO deleteContactVO){

        AcsContactInfo acsContactInfo = new AcsContactInfo();
        try{
            copyProperties(deleteContactVO,acsContactInfo);
            iAcsContactInfoService.updateContactState(acsContactInfo);
        }catch (Exception e){
            e.printStackTrace();
            return failResponse(new SysException(SysExceptionEnum.DELETE_CONTACT_ERROR));
        }

        return successResponse("","更新联系方式状态成功");
    }









}
