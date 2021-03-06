package com.cy.servicetests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pojo.Goods;
import com.cy.service.GoodsService;
import com.cy.service.GoodsServiceImpl;

enum Status{
	SUCCESS,
	FAILED,
}

@SpringBootTest
public class GoodsServiceTests {
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private GoodsServiceImpl goodsServiceImpl;
	
	@Test
	public void testGoods() {
		try {
			Integer i = new Integer(1);
			System.out.println("输入查询id");
			Scanner input = new Scanner(System.in);
			int id = input.nextInt();
			List<Goods> list = goodsService.selectById(id);
			if(list!=null && list.size()>0) {
				for (Goods goods : list) {
					System.out.println(goods);
				}
				System.out.println(Status.SUCCESS);
			}else {
				System.out.println(Status.FAILED);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testFind() {
		List<Goods> list = goodsServiceImpl.allGoods();
		for (Goods goods : list) {
			System.out.println(goods);
		}
	}
	@Test
	public void tests() {
		int a = (int) 56.3;
		Double b = 1.0;
		System.out.println(a%1.0);
	}
	
}
