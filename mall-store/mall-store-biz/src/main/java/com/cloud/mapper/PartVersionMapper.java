package com.cloud.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.entity.PartVersion;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.cloud.param.PartVersionParam;


/**
 *
 * @author 2u c1111
 * @since 1.0 2021-03-05
 */
@Repository
public interface PartVersionMapper extends BaseMapper<PartVersion> {


    List<PartVersion> listQuery(PartVersionParam queryParam);

}
