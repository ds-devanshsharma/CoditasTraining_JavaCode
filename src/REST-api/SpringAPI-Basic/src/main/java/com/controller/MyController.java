package com.controller;

import com.entities.Shop;
import com.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MyController {
    @Autowired
    ShopService service;
    @RequestMapping(path = "/addShop",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    void addShopController(@RequestBody Shop shop){
        service.addShop(shop);
    }

    @GetMapping("/shopList")
    List<Shop> shopListController(){
        return service.showShopList();
    }
}
