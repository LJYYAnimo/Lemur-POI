package com.lemur.poi.entity;


import com.google.common.collect.Lists;

import java.util.List;

/**
 * 数据集合
 */
public class ExportMoreViewEntity {

    private List<ExportViewEntity> moreViewList = Lists.newArrayList();

    public List<ExportViewEntity> getMoreViewList() {
        return moreViewList;
    }

    public void setMoreViewList(List<ExportViewEntity> moreViewList) {
        this.moreViewList = moreViewList;
    }

}
