package com.lemur.poi.entity;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.lemur.poi.utils.FileUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentEntityTests {

    private List<StudentEntity> list;

    @Before
    public void initData(){
        list = new ArrayList<>();
        for(int i=1;i<15;i++){
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setName("测试人员:"+i);
            studentEntity.setSex(1);
            studentEntity.setBirthday(new Date());
            studentEntity.setRegistrationDate(new Date());
            list.add(studentEntity);
        }
    }

    @Test
    public void exportExcelTest(){
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
                StudentEntity .class, list);
        FileUtils.export(workbook,"StudentEntity.xls");
    }

    @Test
    public void importExcelTest(){
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        params.setNeedSave(true);
        List<StudentEntity> list = ExcelImportUtil.importExcel(
                new File("StudentEntity.xls"),
                StudentEntity.class, params);
        System.out.println(list.get(0).toString());
    }
}
