package com.lemur.poi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

public class CompanyHasImgEntity implements Serializable {


    @Excel(name="公司名称",isImportField = "true_st")
    private String name;

    @Excel(name = "公司LOGO", type = 2 ,width = 40 , height = 20,imageType = 2)
    private String logo;

    @Excel(name = "公司地址",isImportField = "true_st")
    private String des;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
