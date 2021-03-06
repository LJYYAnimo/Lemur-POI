package com.lemur.poi.entity;

import cn.afterturn.easypoi.excel.entity.ExportParams;

import java.util.List;

/**
 * 多Sheet导入导出配置类
 */
public class ExportViewEntity {

    public ExportViewEntity(){

    }

    private ExportParams exportParams;

    private List<?> dataList;

    private Class<?> cls;

    public ExportParams getExportParams() {
        return exportParams;
    }

    public void setExportParams(ExportParams exportParams) {
        this.exportParams = exportParams;
    }

    public List<?> getDataList() {
        return dataList;
    }

    public void setDataList(List<?> dataList) {
        this.dataList = dataList;
    }

    public Class<?> getCls() {
        return cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }

    public static class Builder {
        private ExportParams exportParams=null;
        private List<?> dataList=null;
        private Class<?> cls=null;

        public Builder() {

        }
        public Builder exportParams(ExportParams exportParams) {
            this.exportParams = exportParams;
            return this;
        }

        public Builder dataList(List<?> dataList) {
            this.dataList = dataList;
            return this;
        }
        public Builder cls(Class<?> cls) {
            this.cls = cls;
            return this;
        }

        public ExportViewEntity create() {
            return new ExportViewEntity(this);
        }
    }

    public ExportViewEntity(Builder builder) {
        this.exportParams = builder.exportParams;
        this.dataList = builder.dataList;
        this.cls = builder.cls;
    }

}
