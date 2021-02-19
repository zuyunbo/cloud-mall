/**
 * Copyright (C) 2018-2020
 * All rights reserved, Designed By www.yixiang.co

 */
package com.cloud.mallstoreentity.dto;

import lombok.Data;

/**
* @author hupeng
* @date 2020-05-12
*/
@Data
public class YxStoreProductQueryCriteria{

    // 模糊
    private String storeName;

    // 精确
    private Integer isDel;

    private Integer isShow;

    private Integer cateId;
}
