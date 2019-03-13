package com.pinyougou.manager.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
import entity.Result;

//作者:lhh 创建时间:2019年3月2日 下午9:38:13 
@RestController
@RequestMapping("/brand")
public class BrandController {

    Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Reference
    private BrandService brandService;

    /**
     * 查询所有
     *
     * @return
     */
    @RequestMapping("findAll")
    public List<TbBrand> findAll() {
        logger.info("查询品牌列表.");
        return brandService.findAll();
    }

    /**
     * 分页查询
     *
     * @param page 当前页码
     * @param size 每页显示大小
     * @return
     */
    @RequestMapping(value = "/findPage")
    public PageResult findPage(@RequestParam(name = "page", defaultValue = "1") int page,
                               @RequestParam(name = "size", defaultValue = "15") int size) {
        logger.info("page:{},size:{}", page, size);
        return brandService.findPage(page, size);
    }

    /**
     * 新增品牌列表
     *
     * @param brand
     * @return
     */
    @RequestMapping(value = "/add")
    public Result add(@RequestBody TbBrand brand) {
        try {
            brandService.add(brand);
            return new Result(true, "新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "新增失败");
        }
    }

    /**
     * 根据id查询实体类
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/findOne")
    public TbBrand findOne(Long id) {
        return brandService.findOne(id);
    }

    /**
     * 修改品牌列表
     *
     * @param brand
     * @return
     */
    @RequestMapping(value = "/update")
    public Result update(@RequestBody TbBrand brand) {
        try {
            brandService.update(brand);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 批量删除品牌列表
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            brandService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");

        }

    }

    /**
     * 带条件的分页查询
     *
     * @param brand
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand brand, int page, int size) {
        return brandService.findPage(brand, page, size);
    }

    /**
     * @return
     */
    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList() {
        return brandService.selectOptionList();
    }
}
