package com.lin.storage.mapper;

import com.lin.storage.entities.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author linsz
* @description 针对表【t_storage】的数据库操作Mapper
* @createDate 2022-09-02 16:37:21
* @Entity com.lin.storage.entities.Storage
*/
@Mapper
public interface StorageMapper extends BaseMapper<Storage> {

}




