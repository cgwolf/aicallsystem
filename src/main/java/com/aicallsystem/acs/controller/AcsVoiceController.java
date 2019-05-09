package com.aicallsystem.acs.controller;

import com.aicallsystem.acs.common.BaseController;
import com.aicallsystem.acs.common.ResultBean;
import com.aicallsystem.acs.exception.SysException;
import com.aicallsystem.acs.exception.SysExceptionEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import static com.aicallsystem.acs.util.VoiceFileUtil.appendAuthParams;

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
    public ResultBean downloadVoice(HttpServletResponse response){

        try {

            File file = new File("/mnt/" + "test.wav");
            FileInputStream inputStream = new FileInputStream(file);

            ServletOutputStream outputStream = response.getOutputStream();

            response.setContentType("video/mpeg4");
            response.setHeader("Content-Disposition", "attachment;filename="+ "test.wav");

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

    /**
     * <p>
     *     语音识别
     * </p>
     * @param
     * @return
     * @throws
     * @since 5/9/2019
     */
    @ApiOperation(value = "语音识别")
    @GetMapping("translateVoice")
    public ResultBean translateVoice(){

        String fileName = "test.wav";
        String requestData = "{\n" +
                "    \"context\": {\n" +
                "        \"productId\": \"278581694\",\n" +
                "        \"userId\": \"\",   \n" +
                "        \"deviceName\": \"\",\n" +
                "        \"sdkName\": \"\" \n" +
                "    },\n" +
                "    \"request\": {\n" +
                "        \"requestId\": \"1234567890\",\n" +
                "        \"audio\": {\n" +
                "            \"audioType\": \"wav\", \n" +
                "            \"sampleRate\": 16000, \n" +
                "            \"channel\": 1, \n" +
                "            \"sampleBytes\": 2 \n" +
                "                    },\n" +
                "        \"asr\": {\n" +
                "            \"wakeupWord\": \"\", \n" +
                "            \"enableRealTimeFeedback\": true,\n" +
                "            \"enableVAD\": true, \n" +
                "            \"enablePunctuation\": true,\n" +
                "            \"language\": \"zh-CN\", \n" +
                "            \"res\": \"comm\", \n" +
                "            \"lmId\": \"\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        // 调用工具类,生成路径参数
        String url = appendAuthParams();

        // 创建httpClient对象
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        HttpEntity entity = MultipartEntityBuilder.create()
                .addBinaryBody("file", new File("/mnt/" + fileName), ContentType.create("application/octet-stream"), fileName)
                .addTextBody("params", requestData)
                .build();
        httpPost.setEntity(entity);

        try {

            HttpResponse response = httpClient.execute(httpPost);
            return successResponse(EntityUtils.toString(response.getEntity()),"翻译成功!");
        } catch (Exception e) {

            return successResponse(e,"翻译失败!");
        }

    }
}
