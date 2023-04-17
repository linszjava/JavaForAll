package com.lin.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.lin.beans.Brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @program: JavaForAll
 * @description: 增删改查测试
 * @author: linsz
 * @create: 2022-06-17 19:38
 **/
public class CRUDDemo {
    static Connection connection = null;

    static {

        try {
            Properties properties = new Properties();
            FileInputStream io = new FileInputStream("/Users/linsz/Documents/idea/JavaForAll/javaweb/src/main/resources/druid.properties");
            properties.load(io);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //1. 查询列表
    @Test
    public void testSelectAll() throws SQLException {
        String sql = "select * from tb_brand";

        PreparedStatement prestat = connection.prepareStatement(sql);
        ResultSet resultSet = prestat.executeQuery();
        Brand brand = new Brand();
        ArrayList<Brand> brands = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String brandName = resultSet.getString("brand_name");
            String companyName = resultSet.getString("company_name");
            int ordered = resultSet.getInt("ordered");
            String description = resultSet.getString("description");
            brand.setId(id).setBrandName(brandName).setCompanyName(companyName)
                    .setOrdered(ordered).setDescription(description);

            brands.add(brand);
        }
        System.out.println(brands);
    }


    //2. 增加
    @Test
    public void testAdd() throws SQLException {
        String sql = "insert into tb_brand (brand_name, company_name, ordered, description, status)\n" +
                "values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Brand brand = new Brand();
        brand.setBrandName("apple").setCompanyName("苹果公司").setOrdered(100).setDescription("苹果生态").setStatus(1);
        preparedStatement.setString(1, brand.getBrandName());
        preparedStatement.setString(2, brand.getCompanyName());
        preparedStatement.setInt(3, brand.getOrdered());
        preparedStatement.setString(4, brand.getDescription());
        preparedStatement.setInt(5, brand.getStatus());

        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
    }

    @Test
    public void testUpdate() throws SQLException {
        String sql = "update tb_brand set brand_name = '华为2' where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Brand brand = new Brand().setId(2);
        preparedStatement.setInt(1, brand.getId());

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    @Test
    public void testDelete() throws SQLException {
        String sql = "delete from tb_brand where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Brand brand = new Brand().setId(2);
        preparedStatement.setInt(1, brand.getId());
        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }
}
