package com.cloud.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.entity.PartCommon;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.cloud.param.PartCommonParam;


/**
 *
 * @author 2u c1111
 * @since 1.0 2021-03-12
 */
@Repository
public interface PartCommonMapper extends BaseMapper<PartCommon> {


    List<PartCommon> listQuery(PartCommonParam queryParam);

    int saveByEntity(PartCommon partCommon);


}
