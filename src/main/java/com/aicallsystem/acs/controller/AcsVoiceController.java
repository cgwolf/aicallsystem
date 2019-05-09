package com.aicallsystem.acs.controller;

import com.aicallsystem.acs.common.BaseController;
import com.aicallsystem.acs.common.ResultBean;
import com.aicallsystem.acs.exception.SysException;
import com.aicallsystem.acs.exception.SysExceptionEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.client.support.AsyncHttpAccessor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * <p>
 *      voice 文件处理
 * </p>
 *
 * @author ispong
 * @since 2019-04-03
 */
@RestController
@RequestMapping("/voice")
@Api(tags = "音频文件 API")
public class AcsVoiceController extends BaseController {


    /**
     * <p>
     *     音频文件上传
     * </p>
     * @param
     * @return
     * @throws
     * @since 5/9/2019
     */
    @ApiOperation(value = "上传音频文件接口")
    @PostMapping("uploadVoice")
    public ResultBean uploadVoice(@ApiParam(value = "音频文件") @RequestPart(value = "file") MultipartFile multipartFile){



        return null;
    }


    /**
     * <p>
     *     音频文件下载
     * </p>
     * @param
     * @return
     * @throws
     * @since 5/9/2019
     */
    @ApiOperation(value = "下载音频文件接口")
    @GetMapping("downloadVoice")
    public ResultBean downloadVoice(@RequestParam(value = "fileName") String fileName,HttpServletResponse response){

        try {

            File file = new File("/mnt/" + fileName);
            FileInputStream inputStream = new FileInputStream(file);

            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType("video/mpeg4");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }
            return successResponse("", "返回成功");
        } catch (IOException e) {

            return failResponse(new SysException(SysExceptionEnum.AUTH_ERROR));
        }
    }
}
