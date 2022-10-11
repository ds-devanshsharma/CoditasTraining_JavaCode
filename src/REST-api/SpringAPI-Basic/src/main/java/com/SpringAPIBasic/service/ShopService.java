package com.SpringAPIBasic.service;

import com.SpringAPIBasic.entities.Shop;

import java.util.List;

public interface ShopService {
    void addShop(Shop shop);
    List<Shop> showShopList();
    void deleteShop(int shopID);
    void updateShop(int shopID);
}
