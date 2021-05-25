package com.cy.tests;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.dao.GoodsDao;
import com.cy.pojo.Goods;

@SpringBootTest
public class GoodsTests {
	@Autowired
	private GoodsDao goodsDao;
	@Test
	public void testSelectById() {
		List<Goods> list = goodsDao.selectById(1,2,3);
		for (Goods goods : list) {
			System.out.println(goods);
		}
	}
	
}
