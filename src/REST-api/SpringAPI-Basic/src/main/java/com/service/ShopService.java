package com.service;

import com.entities.Shop;

import java.util.List;

public interface ShopService {
    void addShop(Shop shop);
    List<Shop> showShopList();
    void deleteShop(int shopID);
    void updateShop(int shopID);
}
