package com.lin.mapper;

import com.lin.dto.BrandDTO;
import com.lin.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class BrandMapperTest {
    static SqlSession sqlSession = null;

    static {
        InputStream resource = null;
        try {
            resource = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            System.out.println("文件未找到" + e.getMessage());
            e.printStackTrace();
        }
    }


    @Test
    public void selectAllBrand() {
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        System.out.println(brandMapper.selectAllBrand());
    }

    @Test
    public void selectById() {
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        System.out.println(brandMapper.selectById(2));
    }

    @Test
    public void selectByCondition() {
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setStatus(1).setBrandName("华为").setCompanyName("华为");
        List<Brand> brands = brandMapper.selectByCondition(brand.getStatus(), brand.getBrandName(), brand.getCompanyName());
        System.out.println(brands);

    }

    @Test
    public void SelectByConditionDTO() {
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        BrandDTO brandDTO = new BrandDTO().setStatus(null).setBrandName("华为").setCompanyName(null);
        List<Brand> brands = brandMapper.selectByConditionDTO(brandDTO);
        System.out.println(brands);
    }

    @Test
    public void selectByConditionUseMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", 1);
        map.put("brandName", "华为");
        map.put("companyName", null);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        System.out.println(mapper.selectByConditionUseMap(map));
    }

    @Test
    public void addBrand() {
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setBrandName("apple").setStatus(1).setDescription("苹果生态还行").setOrdered(1000).setCompanyName("APPLE");
        mapper.addBrand(brand);

    }

    @Test
    public void updateBrand() {
        Brand brand = new Brand();
        brand.setId(2).setBrandName("huawei");
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        System.out.println(mapper.updateBrand(brand));
    }

    @Test
    public void deleteBrandById() {
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        System.out.println(mapper.deleteBrandById(10));
    }

    @Test
    public void deleteBrandByIds() {
        int[] ints = new int[]{13};
        System.out.println(sqlSession.getMapper(BrandMapper.class).deleteBrandByIds(ints));

    }

    @Test
    public void deleteBrandByIdsUseList() {
        System.out.println(sqlSession.getMapper(BrandMapper.class).deleteBrandByIdsUseList(Arrays.asList(12)));
    }

    @Test
    public void selectBrandBySingleType() {
        BrandDTO brandDTO = new BrandDTO().setStatus(1);
        System.out.println(sqlSession.getMapper(BrandMapper.class).selectBrandBySingleType(brandDTO));

    }
}