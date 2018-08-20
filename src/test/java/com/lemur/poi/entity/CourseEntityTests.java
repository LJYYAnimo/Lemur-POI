package com.lemur.poi.entity;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.lemur.poi.utils.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @Description :
 * ---------------------------------
 * @Author : Animo QQ:1151757358
 * @Date : 2018/8/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseEntityTests {

    @Test
    public void exportExcelTest(){
        List<CourseEntity> list = new ArrayList<>();
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(1);
        courseEntity.setName("语文课");
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId("1");
        teacherEntity.setName("张三丰");
        courseEntity.setMathTeacher(teacherEntity);
        List<StudentEntity> studentEntities = new ArrayList<>();
        for(int i=1;i<15;i++){
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setId(i);
            studentEntity.setSex(2);
            studentEntity.setName("学员:"+i);
            studentEntity.setBirthday(new Date());
            studentEntity.setRegistrationDate(new Date());
            studentEntities.add(studentEntity);
        }
        courseEntity.setStudents(studentEntities);
        list.add(courseEntity);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("南京市兰溪小学", null, "课程"),
                CourseEntity.class, list);
        FileUtils.export(workbook,"CourseEntity.xls");
    }

}
