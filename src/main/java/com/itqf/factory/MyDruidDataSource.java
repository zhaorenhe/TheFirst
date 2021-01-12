package com.itqf.factory;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2021/1/11
 * @Time: 下午2:11
 */
public class MyDruidDataSource extends PooledDataSourceFactory {

    public MyDruidDataSource(){
        System.out.println("------数据源。。。。。。");
        this.dataSource = new  DruidDataSource();
    }


}
