package com.example.demo.mapper;

import com.example.demo.relation.Cart;
import com.example.demo.linkClass.CartProduct;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartMapper {
    /* TODO */
    @Select("SELECT * " +
            "FROM cartinfor,products " +
            "WHERE customerId=#{customerId} and products.productId=cartinfor.productId")
    public List<CartProduct> getAllCart(@Param("customerId") Integer customerId);
    /* TODO */

    @Update("update cartinfor set isSelect=not isSelect where customerId=#{customerId} and productId=#{productId}")
    int changeCheckbox(@Param("customerId") int customerId,@Param("productId") int productId);

    @Select("SELECT * FROM cartinfor WHERE customerId=#{customerId} AND isSelect")
    public List<Cart> getAllSelect(@Param("customerId") int customerId);

    @Delete("DELETE FROM cartinfor WHERE customerId=#{customerId} AND isSelect")
    public int deleteAllSelect(@Param("customerId") int customerId);

    @Delete("delete from cartinfor where customerId=#{customerId} and productId=#{productId}")
    public int delProduct(@Param("customerId") int customerId,@Param("productId") int productId);

    @Select("select * from cartinfor where customerId=#{customerId} and productId=#{productId}")
    public List<Cart> check(@Param("customerId") int customerId,@Param("productId") int productId);

    @Insert("insert into cartinfor set customerId=#{customerId},productId=#{productId},isSelect=0,num=1") /* TODO */
    public int addProduct(@Param("customerId") int customerId,@Param("productId") int productId);

    @Update("update cartinfor set num=num+1 where customerId=#{customerId} and productId=#{productId}")
    public int plusProductNum(@Param("customerId")int customerId,@Param("productId")int productId);

    @Update("update cartinfor set num=num-1 where customerId=#{customerId} and productId=#{productId} and num>1")
    public int minusProductNum(@Param("customerId")int customerId,@Param("productId")int productId);

}
