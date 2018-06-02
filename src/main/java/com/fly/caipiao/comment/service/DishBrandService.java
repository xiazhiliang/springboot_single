package com.fly.caipiao.comment.service;

import com.fly.caipiao.comment.entity.DishBrand;
import com.fly.caipiao.comment.entity.DishShop;

/**
 * @author baidu
 * @date 2018/5/13 下午10:54
 * @description ${TODO}
 **/
public interface DishBrandService {
    /**
     *
     * @param dishBrand
     * @return
     */
    Integer insertDishBrand(DishBrand dishBrand);

    /**
     *
     * @param dishShop
     * @return
     */
    Integer insertDishShop(DishShop dishShop);

    /**
     *
     * @param id
     * @return
     */
    DishBrand getDishBrandById(Long id);

    /**
     *
     * @param id
     * @return
     */
    DishShop getDishShop(Long id);
}
