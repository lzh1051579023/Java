package com.cy.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.dao.GoodsDao;
import com.cy.pojo.Goods;

@Service
public class GoodsServiceImpl implements GoodsService{
	private int rows;
	private BigDecimal t = new BigDecimal(1000 + "");
	Logger log = LoggerFactory.getLogger(GoodsServiceImpl.class);
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public List<Goods> selectById(Integer... id) {
		log.info("start {}",System.currentTimeMillis()+"ms");
		long start = System.currentTimeMillis();
		List<Goods> list = goodsDao.selectById(id);
		long end = System.currentTimeMillis();
		BigDecimal s = new BigDecimal(start);
		BigDecimal e = new BigDecimal(end);
		System.out.println("查询耗时:" + (e.subtract(s)).divide(t,2,BigDecimal.ROUND_HALF_UP) + "s");
		log.info("end {}",System.currentTimeMillis()+"ms");
		return list;
	}

	@Override
	public List<Goods> allGoods() {
		long start = System.currentTimeMillis();
		BigDecimal s = new BigDecimal(start);
		List<Goods> list = goodsDao.selectAllGoods();

		Long end = System.currentTimeMillis();
		BigDecimal e = new BigDecimal(end);
		System.out.println("查询耗时:" + (e.subtract(s)).divide(t,3,BigDecimal.ROUND_HALF_UP) + "s");
		return list;
	}

	@Override
	public int addGoods(Goods goods) {
		long start = System.currentTimeMillis();
		BigDecimal s = new BigDecimal(start);
		if(goods==null) {
			throw new NoSuchElementException("对象不存在");
		}else if(checkName(goods.getName())) {
			throw new NoSuchElementException("商品已存在");
		}else {			
			rows = goodsDao.insertGoods(goods);
		}
		Long end = System.currentTimeMillis();
		BigDecimal e = new BigDecimal(end);
		System.out.println("添加耗时:" + (e.subtract(s)).divide(t,3,BigDecimal.ROUND_HALF_UP) + "s");
		return rows;
	}

	@Override
	public int deleteGoodsById(Long id) {
		long start = System.currentTimeMillis();
		BigDecimal s = new BigDecimal(start);
		if(id<1) {
			throw new NoSuchElementException("记录不存在");
		}else {
			rows = goodsDao.goodsDelete(id);
		}
		Long end = System.currentTimeMillis();
		BigDecimal e = new BigDecimal(end);
		System.out.println("删除耗时:" + (e.subtract(s)).divide(t,3,BigDecimal.ROUND_HALF_UP) + "s");
		return rows;
	}

	@Override
	public int updateById(Goods goods) {
		long start = System.currentTimeMillis();
		BigDecimal s = new BigDecimal(start);
		if(goods==null) {
			throw new NoSuchElementException("记录不存在");
		}else if(goods.getId()<1) {
			throw new NoSuchElementException("id不正确");
		}
		else {
			rows = goodsDao.goodsUpdate(goods);
			System.out.println(goods.getName()+goods.getRemark());
		}
		Long end = System.currentTimeMillis();
		BigDecimal e = new BigDecimal(end);
		System.out.println("修改耗时:" + (e.subtract(s)).divide(t,3,BigDecimal.ROUND_HALF_UP) + "s");
		return rows;
	}

	@Override
	public boolean checkName(String name) {
		List<Goods> list = goodsDao.findName(name);
		if(list.size()==0) {
			return false;
		}else {			
			return true;
		}
	}
	
}
