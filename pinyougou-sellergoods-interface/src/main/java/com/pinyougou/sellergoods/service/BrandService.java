package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

//作者:lhh 创建时间:2019年3月2日 下午9:26:38 
/**
 * 品牌接口
 * 
 * @author lhh
 *
 */
public interface BrandService {
	// 查询品牌列表
	public List<TbBrand> findAll();
	/**
	 * 分页,不带条件
	 * @param pageNum 当前页
	 * @param pageSize 当前页大小
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	/**
	 * 新增品牌列表
	 * @param brand
	 */
	public void add(TbBrand brand);
	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	public TbBrand findOne(Long id);
	/**
	 * 修改实体
	 * @param brand
	 */
	public void update(TbBrand brand);
	
	/**
	 * 根据id批量删除品牌列表
	 * @param ids
	 */
	public void delete(Long[] ids);

	/**
	 * 分页，带条件查询
	 * @param brand 查询条件
	 * @param pageNum 当前页
	 * @param pageSize 当前页大小
	 * @return
	 */
	public PageResult findPage(TbBrand brand, int pageNum, int pageSize);
	//返回下拉列表的数据
	public  List<Map> selectOptionList();

	
}
