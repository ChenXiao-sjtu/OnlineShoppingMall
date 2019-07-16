package com.how2java.tmall.mapper;

import com.how2java.tmall.pojo.Seller;
import com.how2java.tmall.pojo.SellerExample;
import java.util.List;

public interface SellerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Seller record);

    int insertSelective(Seller record);

    List<Seller> selectByExample(SellerExample example);

    Seller selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Seller record);

    int updateByPrimaryKey(Seller record);
}