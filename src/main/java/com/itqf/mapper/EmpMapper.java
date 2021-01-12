package com.itqf.mapper;

import com.itqf.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2021/1/11
 * @Time: 上午9:10
 */
public interface EmpMapper {


    public Emp findById(int id);
    public List<Emp> findByAll();

    //where + if
    public List<Emp> findByCondition(Emp emp);
    //trim(拼接where)+if
    public List<Emp> findByCondition1(Emp emp);


   //set +if
    public   int  update(Emp emp);

    //trim+if
    public   int  update1(Emp emp);

    // foreach
    public  List<Emp>  findByIds(List<Integer> ids);


    public  List<Emp>  findByPage(@Param("offset") int offset
            ,@Param("pageSize") int limit);


}
