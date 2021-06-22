/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.example.litgeneratemaster.domain;

import lombok.Builder;
import lombok.Data;

/**
 * 列的属性
 * 
 * @author 2u
 */
@Data
@Builder
public class ColumnData {
    /**
     * 列名名称
     */
    private String columnName;
    /**
     * 列名类型
     */
    private String columnType;
    /**
     * 雷鸣备注
     */
    private String columnComment;

}
