package test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itqf.entity.Emp;
import com.itqf.mapper.EmpMapper;
import com.itqf.utils.MyBatisUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2021/1/11
 * @Time: 上午9:26
 */
public class TestMybatis {

    @Test
    public   void  testWhereAndIF(){
        EmpMapper empMapper = MyBatisUtils.getMapper(EmpMapper.class);

        System.out.println(empMapper.findById(1));
        System.out.println("---------");
        System.out.println(empMapper.findByAll());
        System.out.println("---------");

        Emp emp = new Emp();//没有条件
        // select emp_id as empId,name,age,sex,salary from emp
        System.out.println(empMapper.findByCondition(emp));

        emp.setAge(18);
        emp.setName("卷");//有条件   select emp_id as empId,name,age,sex,salary from emp WHERE name like concat('%',?,'%') and age=?
        System.out.println(empMapper.findByCondition(emp));


    }

    @Test
    public   void  testUpdate(){
        EmpMapper empMapper = MyBatisUtils.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setAge(18);
        emp.setName("大卷卷");
        emp.setEmpId(1);

        int i = empMapper.update(emp);//update emp SET name=?, age=? where emp_id=?

        MyBatisUtils.commit();
        System.out.println(i>0?"修改成功":"修改失败");

        System.out.println("------------");
        empMapper = MyBatisUtils.getMapper(EmpMapper.class);
        emp.setSalary(20000);
         i = empMapper.update(emp);//update emp SET name=?, age=?, salary=? where emp_id=?

        MyBatisUtils.commit();
        System.out.println(i>0?"修改成功":"修改失败");


    }

    @Test
    public   void  testTrim(){
        EmpMapper empMapper = MyBatisUtils.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setAge(18);
        emp.setName("大卷卷");
        emp.setEmpId(1);
        emp.setSalary(20000);
        //trim+if
        int i = empMapper.update1(emp);// update emp SET name=?, age=?, salary=? where emp_id=?

        MyBatisUtils.commit();
        System.out.println(i>0?"修改成功":"修改失败");
        System.out.println("--------");
        empMapper = MyBatisUtils.getMapper(EmpMapper.class);

        System.out.println(empMapper.findByCondition1(emp));


    }

    @Test
    public   void  testForeach(){
        EmpMapper empMapper = MyBatisUtils.getMapper(EmpMapper.class);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(empMapper.findByIds(list));
        //select emp_id as empId,name,age,sex,salary from emp
        // WHERE emp_id in ( ? , ? , ? )

        System.out.println("---------");
        list.add(4);
        System.out.println(empMapper.findByIds(list));
        //select emp_id as empId,name,age,sex,salary from emp
        // WHERE emp_id in ( ? , ? , ? , ? )



    }

    @Test
    public    void  testPage(){
        //传统分页
        EmpMapper empMapper = MyBatisUtils.getMapper(EmpMapper.class);
        System.out.println( empMapper.findByPage(0,2));
        System.out.println( empMapper.findByPage(2,2));

        System.out.println("-----------");
        //分页插件的分页
        //1,设置分页规则
        PageHelper.offsetPage(3,2);
        //2，调用查询语句
        List<Emp> list = empMapper.findByAll();
        //3，处理结果
        PageInfo<Emp> pageInfo = new PageInfo<>(list);
        //4,得到分页后的数据
        System.out.println("分页后集合："+pageInfo.getList());
        System.out.println("总的记录数："+pageInfo.getTotal());
        System.out.println("第："+pageInfo.getPageNum()+"页");
        System.out.println("总的："+pageInfo.getPages()+"页");


    }


}
