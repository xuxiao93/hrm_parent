package com.xurui.hrm.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.xurui.hrm.domain.Pager;
import com.xurui.hrm.query.PagerQuery;
import com.xurui.hrm.service.IPagerService;
import com.xurui.hrm.util.AjaxResult;
import com.xurui.hrm.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pager")
public class PagerController {
    @Autowired
    public IPagerService pagerService;

    /**
    * 保存和修改公用的
    * @param pager  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Pager pager){
        pager.setCreateTime(new Date());
        try {
            if(pager.getId()!=null){
                pagerService.updateById(pager);
            }else{
                pagerService.insert(pager);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("保存对象失败！"+e.getMessage());
        }
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            pagerService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Pager get(@PathVariable("id")Long id)
    {
        return pagerService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Pager> list(){

        return pagerService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<Pager> json(@RequestBody PagerQuery query)
    {
        Page<Pager> page = new Page<Pager>(query.getPage(),query.getRows());
            page = pagerService.selectPage(page);
            return new PageList<Pager>(page.getTotal(),page.getRecords());
    }
}
