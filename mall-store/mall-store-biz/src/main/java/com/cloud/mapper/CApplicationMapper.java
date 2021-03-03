package com.cloud.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.entity.CApplication;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.cloud.param.CApplicationParam;


/**
 *
 * @author 2u c1111
 * @since 1.0 2021-03-02
 */
@Repository
public interface CApplicationMapper extends BaseMapper<CApplication> {


    List<CApplication> listQuery(CApplicationParam queryParam);

}
