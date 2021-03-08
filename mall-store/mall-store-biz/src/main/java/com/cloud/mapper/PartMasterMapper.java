package com.cloud.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.entity.PartMaster;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.cloud.param.PartMasterParam;


/**
 *
 * @author 2u c1111
 * @since 1.0 2021-03-05
 */
@Repository
public interface PartMasterMapper extends BaseMapper<PartMaster> {


    List<PartMaster> listQuery(PartMasterParam queryParam);

}
