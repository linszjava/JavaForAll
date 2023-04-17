package com.lin.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.lin.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @program: mybatis-plus
 * @description: user实体类
 * @author: linsz
 * @create: 2022-07-27 10:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
//@TableName("t_user")
public class User {

//    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

//    @TableField
    private String name;
    private Integer age;
    private String email;

    /**
     * 性别
     */
    private SexEnum sex;

    /**
     * 是否逻辑删除 0：否 1：是
     */
    @TableLogic
    private Integer isDelete;


}
