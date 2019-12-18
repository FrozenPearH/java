package com.hand.hlz25720.controller;

import com.github.pagehelper.PageException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.hlz25720.bean.Msg;
import com.hand.hlz25720.bean.SsmItem;
import com.hand.hlz25720.bean.SsmItems;
import com.hand.hlz25720.service.SsmItemService;
import org.apache.taglibs.standard.extra.spath.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SsmItemController {

    @Autowired
    SsmItemService ssmItemService;
    @RequestMapping("/items")
    @ResponseBody
    public Msg getItemsWithJson(@RequestParam(value = "pn" , defaultValue = "1") Integer pn ,@RequestParam(value = "pageSize1" ,defaultValue = "5") Integer pageSize1){
        //        引入PageHelper分页插件
        PageHelper.startPage(pn,pageSize1);
        //        startPage后面紧跟的就是分页查询
        List<SsmItem> items = ssmItemService.getAll();
        //        使用pageInfo包装查询后的结果,只需要将pageInfo交给页面就行了
        //        封装了详细的分页信息,包括查询出来的数据,传入连续传入的页数
        PageInfo page = new PageInfo(items,5);
        return Msg.success().add("pageInfo",page);
    }

    /*
    删除
    单个：传入ids方式：1
     */
    @ResponseBody
    @RequestMapping(value = "/item/{id}",method = RequestMethod.DELETE)
    public Msg deleteItemById(@PathVariable("id") Integer id){
            ssmItemService.deleteItem(id);
        return Msg.success();
    }

//        批量删除：传入codes方式：ITEM0000257204-ITEM0000257205-ITEM0000257206
    @ResponseBody
    @RequestMapping(value = "itemD/{codes}", method = RequestMethod.DELETE)
    public Msg deleteItemByCode(@PathVariable("codes") String codes){
        if (codes.contains("-")){
//            多选
            List<String > del_codes = new ArrayList<>();
            String[] str_codes = codes.split("-");
            for(String string : str_codes){
                del_codes.add(string);
            }
            ssmItemService.deleteBatch(del_codes);
        }else {
//            单选
            List<String > del_codes = new ArrayList<>();
            del_codes.add(codes);
            ssmItemService.deleteBatch(del_codes);
        }
        return Msg.success();
    }

//    新增
    @ResponseBody
    @RequestMapping(value = "/itemSave",method = RequestMethod.POST)
    public Msg saveItem(SsmItems ssmItems){
        LocalDate startlocalDate = LocalDate.parse(ssmItems.getStartActiveDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endlocalDate = LocalDate.parse(ssmItems.getEndActiveDate(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        SsmItem ssmItem = new SsmItem(ssmItemService.addCode(),ssmItems.getItemUom(),ssmItems.getitemDescription(),startlocalDate,endlocalDate,ssmItems.getEnabledFlag());
        ssmItemService.saveItem(ssmItem);
        return Msg.success();
    }

//    查询物料信息
    @RequestMapping(value = "/itemSelect/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Msg getItem(@PathVariable("id") Integer id){
        SsmItem ssmItem = ssmItemService.getItem(id);
        return Msg.success().add("item",ssmItem);
    }

//    修改物料信息
    @ResponseBody
    @RequestMapping(value = "/itemU/{itemCode}",method = RequestMethod.PUT)
    public Msg updetaItem(SsmItems ssmItems){
        LocalDate startlocalDate = LocalDate.parse(ssmItems.getStartActiveDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endlocalDate = LocalDate.parse(ssmItems.getEndActiveDate(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        SsmItem ssmItem = new SsmItem();
        ssmItem.setItemCode(ssmItems.getItemCode());
        ssmItem.setitemDescription(ssmItems.getitemDescription());
        ssmItem.setItemUom(ssmItems.getItemUom());
        ssmItem.setStartActiveDate(startlocalDate);
        ssmItem.setEndActiveDate(endlocalDate);
        ssmItem.setEnabledFlag(ssmItems.getEnabledFlag());
        ssmItemService.updateItem(ssmItem);
        return Msg.success();
    }

//    搜索
    @ResponseBody
    @RequestMapping(value = "/itemS" , method = RequestMethod.GET)
    public Msg selectItem(SsmItems ssmItems){
        SsmItem ssmItem = new SsmItem();
        String start = ssmItems.getStartActiveDate().trim();
        String end = ssmItems.getEndActiveDate().trim();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        boolean date = true;
        try {
            format.parse(start);
            format.parse(end);
        }catch (ParseException e){
            date=false;
            e.printStackTrace();
        }
        if (date == true){
            LocalDate startlocalDate = LocalDate.parse(ssmItems.getStartActiveDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate endlocalDate = LocalDate.parse(ssmItems.getEndActiveDate(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            ssmItem.setStartActiveDate(startlocalDate);
            ssmItem.setEndActiveDate(endlocalDate);
        }
        ssmItem.setItemCode(ssmItems.getItemCode());
        ssmItem.setitemDescription(ssmItems.getitemDescription());
        ssmItem.setItemUom(ssmItems.getItemUom());
        ssmItem.setEnabledFlag(ssmItems.getEnabledFlag());
        List<SsmItem> ssmItems1 = ssmItemService.selectItem(ssmItem);
        PageInfo page = new PageInfo(ssmItems1,5);
        return Msg.success().add("pageInfo",page);
    }
}
