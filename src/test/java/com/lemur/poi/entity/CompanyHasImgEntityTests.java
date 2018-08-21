package com.lemur.poi.entity;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.lemur.poi.utils.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyHasImgEntityTests {

    List<CompanyHasImgEntity> list;

    @Before
    public void initData() {
        list = new ArrayList<>();
        list.add(new CompanyHasImgEntity("百度", "C:\\Users\\DELL\\Desktop\\1.jpg", "北京市海淀区西北旺东路10号院百度科技园1号楼"));
        list.add(new CompanyHasImgEntity("阿里巴巴", "C:\\Users\\DELL\\Desktop\\1.jpg", "北京市海淀区西北旺东路10号院百度科技园1号楼"));
        list.add(new CompanyHasImgEntity("Lemur", "C:\\Users\\DELL\\Desktop\\1.jpg", "亚马逊热带雨林"));
        list.add(new CompanyHasImgEntity("一众", "C:\\Users\\DELL\\Desktop\\1.jpg", "山东济宁俺家"));
    }

    @Test
    public void exportExcelTest() {
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), CompanyHasImgEntity.class, list);
        FileUtils.export(workbook, "CompanyHasImgEntity.xls");
    }

    @Test
    public void importExcelTest() {
        ImportParams params = new ImportParams();
        params.setNeedSave(true);
        params.setSaveUrl("/upload/excelUpload");
        List<CompanyHasImgEntity> result = ExcelImportUtil.importExcel(new File("CompanyHasImgEntity.xls"), CompanyHasImgEntity.class, params);
        System.out.println(result.get(0).toString());
    }
}
