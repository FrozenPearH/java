package com.hand.hlz25720.service;

import com.hand.hlz25720.bean.Complex;
import com.hand.hlz25720.bean.SsmItem;
import com.hand.hlz25720.bean.SsmItems;
import com.hand.hlz25720.mapper.SsmItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(isolation = Isolation.READ_COMMITTED)
@Service
public class SsmItemService {

//    查询所有物料
    @Autowired
    SsmItemMapper ssmItemMapper;
    public List<SsmItem> getAll(){
        return ssmItemMapper.selectAll();
    }

//    根据id删除物料
    public void deleteItem(Integer id){
        ssmItemMapper.deleteById(id);
    }

//    根据编码删除物料
    public void deleteBatch(List<String> codes){
        Complex complex = new Complex();
        Complex.Criteria criteria = complex.createCriteria();
        criteria.anditemCodeIn(codes);
        ssmItemMapper.deleteByExample(complex);
    }

//    找到最大物料编码
    public String maxCode(){
        return ssmItemMapper.selectMaxCode();
    }

    //    最大物料编码自动向后加一
    public  String addOne(String testStr){
        String[] strs = testStr.split("[^0-9]");//根据不是数字的字符拆分字符串
        String numStr = strs[strs.length-1];//取出最后一组数字
        if(numStr != null && numStr.length()>0){//如果最后一组没有数字(也就是不以数字结尾)，抛NumberFormatException异常
            int n = numStr.length();//取出字符串的长度
            int num = Integer.parseInt(numStr)+1;//将该数字加一
            String added = String.valueOf(num);
            n = Math.min(n, added.length());
            //拼接字符串
            return testStr.subSequence(0, testStr.length()-n)+added;
        }else{
            throw new NumberFormatException();
        }
    }

//    自动加一
    public String  addCode(){

        String maxcode = this.maxCode();
        return this.addOne(maxcode);

    }

    //    新增物料
    public void saveItem(SsmItem ssmItem){
        ssmItemMapper.insertItem(ssmItem);
    }

//    按照物料编码查物料
    public SsmItem getItem(Integer id){
        SsmItem ssmItem = ssmItemMapper.selectItemByCode(id);
        return ssmItem;
    }

//    修改
    public void updateItem(SsmItem ssmItem){
        ssmItemMapper.updateByCode(ssmItem);
    }

//    搜索
    public List<SsmItem> selectItem(SsmItem ssmItem) {
        return ssmItemMapper.selectItem(ssmItem);
    }
}
