package com.cy.service;

import java.util.List;

import com.cy.pojo.Goods;

public interface GoodsService {
	List<Goods> selectById(Integer...id);
	
	List<Goods> allGoods();
	
	int addGoods(Goods goods);
	
	int deleteGoodsById(Long id);
	
	int updateById(Goods goods);
	
	boolean checkName(String name);
}
