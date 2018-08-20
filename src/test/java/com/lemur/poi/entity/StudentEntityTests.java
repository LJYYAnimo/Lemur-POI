package com.lemur.poi.entity;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.lemur.poi.utils.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentEntityTests {

    @Test
    public void exportExcelTest(){

        List<StudentEntity> list = new ArrayList<>();
        for(int i=1;i<15;i++){
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setName("测试人员:"+i);
            studentEntity.setSex(1);
            studentEntity.setBirthday(new Date());
            studentEntity.setRegistrationDate(new Date());
            list.add(studentEntity);
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
                StudentEntity .class, list);
        FileUtils.export(workbook,"StudentEntity.xls");
    }

}
