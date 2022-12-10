package com.example.demo.mapper;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.utils.Filter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ProductsMapper {

    @Select("select price from products where productId=#{productId}")
    double getPrice(int productId);

    @Select("select * from products")
    List<Product> findAll();

    @Select("SELECT * FROM products WHERE brand=#{brand}")
    List<Product> selectByBrand(@Param("brand") String brand);

    /**
     * 传入数据要求：
     * data{
     *     price1: 最低价,
     *     price2: 最高价
     * }
     * 如果没填的话可以设为null
     */

     //奇怪的用法。。。反正如果不用泛型的话会一直报错
     List<Product> selectByPrice(@Param("price1")double price1, @Param("price2")double price2);


    @Select("SELECT * FROM products WHERE size=#{size}")
    List<Product> selectBySize(@Param("size") double size);

    /**
     * 传入数据要求：
     * data{
     *     brand:可以为空（为空表示不加限制索引），
     *     price1: 最低价,
     *     price2: 最高价,
     *     size: 尺寸（可以是空）,
     *     sortIndex: 按照价格/销量排序
     *     order: 升序(DESC)或者是降序(ASC) 可以是空，如果非空只能是这两个关键字
     * }
     * @return
     */
    List<Product> selectFilter(@RequestBody Filter filter);
    //@Param("brand") String brand,@Param("price1")double price1, @Param("price2")double price2,@Param("size") double size,
                     //     @Param("sortIndex") String sortIndex,@Param("order") String order
}
