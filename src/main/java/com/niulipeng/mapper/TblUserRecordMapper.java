package com.niulipeng.mapper;

import com.niulipeng.bean.TblUserRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户档案 Mapper 接口
 * </p>
 *
 * @author lian
 * @since 2021-07-29
 */
@Component
public interface TblUserRecordMapper extends BaseMapper<TblUserRecord> {

    public TblUserRecord login(String username,String password);

}
