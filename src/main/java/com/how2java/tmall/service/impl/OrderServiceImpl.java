package com.how2java.tmall.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.mapper.OrderMapper;
import com.how2java.tmall.service.OrderService;
import com.how2java.tmall.service.UserService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    CategoryMapper categoryMapper;      // 新添加

    @Autowired
    OrderItemService orderItemService;


    @Override
    public void add(Order c) {
        orderMapper.insert(c);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
    public float add(Order o, OrderItem oi) {
        float total = 0;
        if (oi != null){
            add(o);

            if(false)
                throw new RuntimeException();

            oi.setOid(o.getId());
            orderItemService.update(oi);
            total+=oi.getProduct().getPromotePrice()*oi.getNumber();
        }
        return total;
    }

    @Override
    public void delete(int id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Order c) {
        orderMapper.updateByPrimaryKeySelective(c);
    }

    @Override
    public Order get(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    public List<Order> list(){
        OrderExample example =new OrderExample();
        example.setOrderByClause("id desc");
        return orderMapper.selectByExample(example);

    }

    public List<Order> list(int sid){
        List<Order> list = new ArrayList<>();

        CategoryExample exampleTest = new CategoryExample();
        exampleTest.createCriteria().andSidEqualTo(sid);
        exampleTest.setOrderByClause("id desc");
        List<Category> c = categoryMapper.selectByExample(exampleTest);

        for (Category ct: c){
            OrderExample example =new OrderExample();
            example.createCriteria().andCidEqualTo(ct.getId()); // 由sid得到cid
            example.setOrderByClause("id desc");

            list.addAll(orderMapper.selectByExample(example));
        }

        return list;
    }

    @Override
    public List list(int uid, String excludedStatus) {
        OrderExample example =new OrderExample();
        example.createCriteria().andUidEqualTo(uid).andStatusNotEqualTo(excludedStatus);
        example.setOrderByClause("id desc");
        return orderMapper.selectByExample(example);
    }

}