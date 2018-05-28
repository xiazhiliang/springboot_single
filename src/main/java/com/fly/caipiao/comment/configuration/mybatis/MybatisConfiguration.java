package com.fly.caipiao.comment.configuration.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/**
 * @author baidu
 * @date 2018/5/27 下午18:12
 * @description mybatis数据源配置
 **/

@Configuration
@AutoConfigureBefore({MybatisAutoConfiguration.class})
public class MybatisConfiguration {

    @Autowired
    private MybatisAutoConfiguration configuration;

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        return configuration.sqlSessionFactory(dataSource);
    }

}
