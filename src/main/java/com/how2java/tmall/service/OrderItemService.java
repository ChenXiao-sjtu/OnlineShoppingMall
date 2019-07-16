package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;

import javax.servlet.http.HttpSession;

public interface OrderItemService {


    void add(OrderItem c);

    void delete(int id);
    void update(OrderItem c);
    OrderItem get(int id);
    List list();
    List list(int cid);

    void fill(List<Order> os);

    void fill(Order o);

//    int getSaleCount(int  pid);

    List<OrderItem> listByUser(int uid);
}