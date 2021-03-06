package com.cy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.pojo.Goods;
import com.cy.service.GoodsService;

@Controller
@RequestMapping("/Goods/")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	/*
	 * 根据指定id查询
	 */
	@RequestMapping("selectGoods")
	public String selectGoods(Integer id) {
		List<Goods> goods = goodsService.selectById(id);
		
		return "goods_list";
	}
	/*
	 * 查询所有goods
	 */
	@RequestMapping("goodsUI")
	public String goodsUI(Model model) {
		List<Goods> list = goodsService.allGoods();
		model.addAttribute("List", list);
		return "goods_list";
	}
	/*
	 * 资源指向添加页面
	 */
	@RequestMapping("toAddGoods")
	public String toaddGoods() {
		return "goods_add";
	}
	/*
	 * 添加goods并重定向到首页
	 */
	@RequestMapping("addGoods")
	public String addGoods(Goods goods) {
		goodsService.addGoods(goods);
		return "redirect:goodsUI";
	}
	/*
	 * 删除goods并重定向到首页
	 */
	@RequestMapping("goodsDelete")
	public String goodsDelete(Long id) {
		goodsService.deleteGoodsById(id);
		return "redirect:goodsUI";
	}
	/*
	 * 点击修改跳转修改页面
	 */
	@RequestMapping("goodsById")
	public String goodsById(Model model,Integer...id) {
		List<Goods> list = goodsService.selectById(id);
		model.addAttribute("act", list);
		return "goods_update";
	}
	/*
	 * 点修改 跳转首页
	 */
	@RequestMapping("goodsUpdate")
	public String goodsUpdate(Goods goods) {
		System.out.println(goods);
		goodsService.updateById(goods);
		return "redirect:goodsUI";
	}
	
}
