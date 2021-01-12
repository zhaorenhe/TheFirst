package com.itqf.entity;

import lombok.Data;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2021/1/11
 * @Time: 上午9:04
 */
@Data  //settings -->Plugins-->输入 lombok搜索--->install--> restart IDEA
public class Emp {

    private Integer empId;
    private String name;
    private  Integer age;//null
    private  String sex;
    private  Integer salary;


}
