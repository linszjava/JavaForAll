package com.lin.account.mapper;

import com.lin.account.entities.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author linsz
* @description 针对表【t_account】的数据库操作Mapper
* @createDate 2022-09-02 16:42:23
* @Entity com.lin.account.entities.Account
*/
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}




