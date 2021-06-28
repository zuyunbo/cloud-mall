/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.example.litgeneratemaster.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 表数据
 * 
 * @author 2u
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TableEntity {

	private String tableName;

	private String comments;

	private ColumnData pk;

	private List<ColumnData> columns;
	
	private String className;

}
