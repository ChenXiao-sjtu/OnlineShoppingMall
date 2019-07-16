package com.how2java.tmall.controller;

import java.io.IOException;
import java.util.List;

import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.util.Page;

// 网站管理员
@Controller
@RequestMapping("")
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    SellerService sellerService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    // 用户管理列表
    @RequestMapping("admin_user_list")
    public String userList(Model model, Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());

        List<User> us= userService.list();

        int total = (int) new PageInfo<>(us).getTotal();
        page.setTotal(total);

        model.addAttribute("us", us);
        model.addAttribute("page", page);

        return "admin/listUser";
    }

    // 删除用户
    @RequestMapping("admin_user_delete")
    public String deleteUser(int id) throws IOException {
        userService.delete(id);
        return "redirect:/admin_user_list";
    }

    // 商家管理列表
    @RequestMapping("admin_seller_list")
    public String sellerList(Model model, Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());

        List<Seller> seller= sellerService.list();

        int total = (int) new PageInfo<>(seller).getTotal();
        page.setTotal(total);

        model.addAttribute("seller", seller);
        model.addAttribute("page", page);

        return "admin/listSeller";
    }

    // 删除商家
    @RequestMapping("admin_seller_delete")
    public String deleteSeller(int id) throws IOException {
        sellerService.delete(id);
        return "redirect:/admin_seller_list";
    }

    // 订单管理列表
    @RequestMapping("admin_order_web_list")
    public String list(Model model, Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Order> os= orderService.list();

        int total = (int) new PageInfo<>(os).getTotal();
        page.setTotal(total);

        orderItemService.fill(os);
        model.addAttribute("os", os);
        model.addAttribute("page", page);

        return "admin/listOrderWeb";
    }

    // 删除订单
    @RequestMapping("admin_order_delete")
    public String deleteOrder(int id) throws IOException {
        orderService.delete(id);
        return "redirect:/admin_order_web_list";
    }

    // 商品分类查看
    @RequestMapping("admin_category_web_list")
    public String categoryList(Model model,Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Category> cs= categoryService.list();
        int total = (int) new PageInfo<>(cs).getTotal();
        page.setTotal(total);
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);

        return "admin/listCategoryWeb";
    }

    // 商品查看
    @RequestMapping("admin_product_web_list")
    public String list(int cid, Model model, Page page) {
        Category c = categoryService.get(cid);

        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Product> ps = productService.list(cid);

        int total = (int) new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        page.setParam("&cid="+c.getId());

        model.addAttribute("ps", ps);
        model.addAttribute("c", c);
        model.addAttribute("page", page);

        return "admin/listProductWeb";
    }

}
