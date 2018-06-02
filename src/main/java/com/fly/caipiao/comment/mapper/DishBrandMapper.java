package com.fly.caipiao.comment.mapper;

import com.fly.caipiao.comment.entity.DishBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author baidu
 * @date 2018/5/13 下午10:30
 * @description ${TODO}
 **/

@Mapper
public interface DishBrandMapper {
    Integer insert(DishBrand dishBrand);
    DishBrand getDishBrand(@Param("id") Long id);
}
