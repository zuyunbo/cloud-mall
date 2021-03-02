package com.cloud.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.entity.CUser;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.cloud.param.CUserParam;


/**
 *
 * @author 2u c1111
 * @since 1.0 2021-02-28
 */
@Repository
public interface CUserMapper extends BaseMapper<CUser> {


    List<CUser> listQuery(CUserParam queryParam);

}
