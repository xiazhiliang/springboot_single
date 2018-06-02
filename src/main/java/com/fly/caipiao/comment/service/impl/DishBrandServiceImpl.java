package com.fly.caipiao.comment.service.impl;

import com.fly.caipiao.comment.entity.DishBrand;
import com.fly.caipiao.comment.entity.DishShop;
import com.fly.caipiao.comment.mapper.DishBrandMapper;
import com.fly.caipiao.comment.mapper.DishShopMapper;
import com.fly.caipiao.comment.service.DishBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author baidu
 * @date 2018/5/13 下午10:57
 * @description ${TODO}
 **/
@Service("dishBrandService")
public class DishBrandServiceImpl implements DishBrandService {

    @Autowired
    private DishBrandMapper dishBrandMapper;
    @Autowired
    private DishShopMapper dishShopMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertDishBrand(DishBrand dishBrand) {
        return dishBrandMapper.insert(dishBrand);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertDishShop(DishShop dishShop) {
        return dishShopMapper.insert(dishShop);
    }

    @Override
    public DishBrand getDishBrandById(Long id) {
        return dishBrandMapper.getDishBrand(id);
    }

    @Override
    public DishShop getDishShop(Long id) {
        return dishShopMapper.getDishShop(id);
    }

}
