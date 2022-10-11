package com.SpringAPIBasic.controller;

import com.SpringAPIBasic.entities.Shop;
import com.SpringAPIBasic.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MyController {
    @Autowired
    ShopService service;
    @RequestMapping(value = "/addShop",method = RequestMethod.POST,consumes = "application/JSON")
    void addShopController(@RequestBody Shop shop){
        service.addShop(shop);
    }

    @GetMapping("/shopList")
    List<Shop> shopListController(){
        return service.showShopList();
    }
}
