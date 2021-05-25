package com.cy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.cy.pojo.Goods;

@Mapper
public interface GoodsDao {
	
	List<Goods> selectById(@Param(value = "ids")Integer...id);
	
	List<Goods> selectAllGoods();
	
	int insertGoods(Goods goods);
	
	int goodsDelete(@Param(value = "ids")Long id);
	
	@Update("update tb_goods set name=#{name},remark=#{remark} where id=#{id}")
	int goodsUpdate(Goods goods);
	
	List<Goods> findName(String name);
}
