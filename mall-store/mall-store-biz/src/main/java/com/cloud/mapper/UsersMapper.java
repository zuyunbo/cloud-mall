package com.cloud.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.entity.Users;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.cloud.param.UsersParam;


/**
 *
 * @author 2u c1111
 * @since 1.0 2021-03-17
 */
@Repository
public interface UsersMapper extends BaseMapper<Users> {


    List<Users> listQuery(UsersParam queryParam);

}
