package com.zrs.serviceedu.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@MapperScan("com.zrs.serviceedu.mapper")
public class Myconfig implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
      this.setFieldValByName("gmtCreate",new Date(),metaObject);
      this.setFieldValByName("gmtModified",new Date(),metaObject);
      this.setFieldValByName("isDeleted",false,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }

}
