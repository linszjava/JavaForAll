package com.lin.mapper;

import com.lin.dto.BrandDTO;
import com.lin.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @program: JavaForAll
 * @description: Brand 接口
 * @author: linsz
 * @create: 2022-06-18 19:31
 **/
public interface BrandMapper {

    /**
     * 1.查看列表选项
     *
     * @return
     */
    List<Brand> selectAllBrand();

    /**
     * 2.按照id查询列表
     *
     * @param id
     * @return
     */
    Brand selectById(int id);

    /**
     * 3.根据具体的参数列表进行查询
     *
     * @param status
     * @param brandName
     * @param companyName
     * @return
     */
    List<Brand> selectByCondition(@Param("status") Integer status, @Param("brandName") String brandName, @Param("companyName") String companyName);

    /**
     * 4.根据BrandDto查询
     *
     * @param brandDTO
     * @return
     */
    List<Brand> selectByConditionDTO(BrandDTO brandDTO);

    /**
     * 5.使用map 查询
     *
     * @param map
     * @return
     */
    List<Brand> selectByConditionUseMap(Map map);

    /**
     * 6. 增加品牌
     *
     * @param brand
     */
    void addBrand(Brand brand);

    /**
     * 7.修改品牌的信息
     *
     * @param brand
     * @return
     */
    int updateBrand(Brand brand);

    /**
     * 8.删除Brand通过id
     *
     * @param id
     * @return
     */
    int deleteBrandById(int id);

    /**
     * 9.批量删除  参数为Array 类型
     *
     * @param ids
     * @return
     */
    int deleteBrandByIds(@Param("ids") int[] ids);

    int deleteBrandByIdsUseList(List<Integer> list);

    /**
     * 10.根据参数的单个属性查询复合条件的所有列表
     *
     * @param brandDTO
     * @return
     */
    List<Brand> selectBrandBySingleType(BrandDTO brandDTO);


}
