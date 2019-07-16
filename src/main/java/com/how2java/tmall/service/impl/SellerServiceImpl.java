package com.how2java.tmall.service.impl;

import com.how2java.tmall.mapper.SellerMapper;
import com.how2java.tmall.pojo.Seller;
import com.how2java.tmall.pojo.SellerExample;
import com.how2java.tmall.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    SellerMapper sellerMapper;

    @Override
    public void add(Seller c){ sellerMapper.insert(c); }

    @Override
    public void delete(int id){
        sellerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Seller c){ sellerMapper.updateByPrimaryKeySelective(c);}

    @Override
    public Seller get(int id){ return sellerMapper.selectByPrimaryKey(id);}

    @Override
    public List list(){
        SellerExample example =new SellerExample();
        example.setOrderByClause("id desc");
        return sellerMapper.selectByExample(example);
    }

    @Override
    public boolean isExist(String name){
        SellerExample example =new SellerExample();
        example.createCriteria().andNameEqualTo(name);
        List<Seller> result= sellerMapper.selectByExample(example);
        if(!result.isEmpty())
            return true;
        return false;
    }

    @Override
    public Seller get(String name, String password){
        SellerExample example =new SellerExample();
        example.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
        List<Seller> result= sellerMapper.selectByExample(example);
        if(result.isEmpty())
            return null;
        return result.get(0);
    }

}
