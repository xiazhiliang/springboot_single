package com.fly.caipiao.comment;

import com.fly.caipiao.comment.entity.DishBrand;
import com.fly.caipiao.comment.entity.DishShop;
import com.fly.caipiao.comment.service.DishBrandService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author baidu
 * @date 2018/5/13 下午11:01
 * @description ${TODO}
 **/
public class DishBrandServiceTest extends BaseTest {
    @Autowired
    private DishBrandService dishBrandService;

    @Test
    public void testInsertDishBrand(){
        DishBrand dishBrand  = new DishBrand();
        dishBrand.setCode("sku001");
        dishBrand.setName("红苹果");
        dishBrandService.insertDishBrand(dishBrand);

        DishShop dishShop = new DishShop();
        dishShop.setBrandDishId(4L);
        dishShop.setCode("sku001");
        dishShop.setName("门店红苹果");
        dishBrandService.insertDishShop(dishShop);
    }
}
