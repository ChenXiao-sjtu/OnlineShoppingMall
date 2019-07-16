package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Seller;

import java.util.List;

public interface SellerService {
    void add(Seller c);
    void delete(int id);
    void update(Seller c);
    Seller get(int id);
    List list();
    boolean isExist(String name);

    Seller get(String name, String password);
}
