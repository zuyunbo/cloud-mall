package com.cloud.mapper;


import com.cloud.cloudbaseutil.base.mapper.SuperMapper;
import com.cloud.entity.CUser;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.cloud.param.CUserParam;


/**
 *
 * @author 2u c1111
 * @since 1.0 2021-03-02
 */
@Repository
public interface CUserMapper extends SuperMapper<CUser> {


    List<CUser> listQuery(CUserParam queryParam);

}
