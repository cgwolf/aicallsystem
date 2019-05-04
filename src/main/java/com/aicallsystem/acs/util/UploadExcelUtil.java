package com.aicallsystem.acs.util;

import com.aicallsystem.acs.entity.AcsConsumerInfo;
import com.aicallsystem.acs.entity.dto.user.MarkUserDto;
import com.aicallsystem.acs.exception.SysException;
import com.aicallsystem.acs.exception.SysExceptionEnum;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *      excel 导入生成器
 * </p>
 * @author ispong
 * @since 5/4/2019
 * @version 1.0.0
 */
public class UploadExcelUtil {

    /**
     * <p>
     *     客户信息导入
     * </p>
     * @param
     * @return
     * @throws
     * @since 5/4/2019
     */
    public static List<AcsConsumerInfo> uploadConsumerUtil(MultipartFile multipartFile, String batch, MarkUserDto markUserDto){

        List<AcsConsumerInfo> acsConsumerInfoList = new ArrayList();

        try {
            InputStream inputStream = multipartFile.getInputStream();
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
            for(int i=1;i<xssfSheet.getLastRowNum()+1;i++){
                AcsConsumerInfo acsConsumerInfo = new AcsConsumerInfo();
                XSSFRow row = xssfSheet.getRow(i);

                acsConsumerInfo.setName(String.valueOf(row.getCell(0)));
                acsConsumerInfo.setCompany(String.valueOf(row.getCell(1)));
                acsConsumerInfo.setPhone(String.valueOf(row.getCell(2)));
                acsConsumerInfo.setSex(String.valueOf(row.getCell(3)));
                acsConsumerInfo.setTypeString(String.valueOf(row.getCell(4)));
                acsConsumerInfo.setRemark(String.valueOf(row.getCell(5)));
                acsConsumerInfo.setUserUuid(markUserDto.getUserUuid());
                acsConsumerInfo.setBatch(batch);

                acsConsumerInfoList.add(acsConsumerInfo);
            }

            for (int i = 0; i < acsConsumerInfoList.size(); i++){
                System.out.println(acsConsumerInfoList.get(i).toString());
            }
        } catch (IOException e) {
            throw new SysException(SysExceptionEnum.UPLOAD_CONSUMER_ERROR);
        }

        return acsConsumerInfoList;
    }

}
