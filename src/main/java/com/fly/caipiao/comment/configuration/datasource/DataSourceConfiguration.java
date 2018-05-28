package com.fly.caipiao.comment.configuration.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author baidu
 * @date 2018/5/27 下午18:10
 * @description 设定数据源
 **/

@Configuration
@EnableTransactionManagement
@AutoConfigureBefore({DataSourceAutoConfiguration.class})
public class DataSourceConfiguration {
    private static Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);

    @Bean({"dataSourceProperties", "properties"})
    @ConfigurationProperties(prefix = "datasource")
    public DataSourceProperties writeDataSourceProperties() {
        return new DataSourceProperties();
    }
    
    @Bean("dataSource")
    public DataSource writeDataSource(
            @Qualifier("dataSourceProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }
    
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManagers(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}