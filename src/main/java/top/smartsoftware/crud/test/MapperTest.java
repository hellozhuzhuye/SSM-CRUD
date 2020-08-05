package top.smartsoftware.crud.test;

import java.util.Random;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.smartsoftware.crud.bean.Employee;
import top.smartsoftware.crud.dao.DepartmentMapper;
import top.smartsoftware.crud.dao.EmployeeMapper;

/**
 * 测试dao层的工作
 * @author lfy
 *推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 *1、导入SpringTest模块
 *2、@ContextConfiguration指定Spring配置文件的位置
 *3、直接autowired要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 测试DepartmentMapper
	 */
	@Test
	public void testCRUD(){
	/*	//1、创建SpringIOC容器
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2、从容器中获取mapper
		DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);*/
		System.out.println(departmentMapper);
		
		//1、插入几个部门
//		departmentMapper.insertSelective(new Department(null, "开发部"));
//		departmentMapper.insertSelective(new Department(null, "测试部"));
		Random random=new Random();
		int id=random.nextInt(4);
		if(id==0)
			id++;
		System.out.println("id====="+id);
		//2、生成员工数据，测试员工插入
		employeeMapper.insertSelective(new Employee(null, "Jerry", "M", "Jerry@qq.com", id));
		
		//3、批量插入多个员工；批量，使用可以执行批量操作的sqlSession。
		
//		for(){
//			employeeMapper.insertSelective(new Employee(null, , "M", "Jerry@atguigu.com", 1));
//		}
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i = 0;i<1149;i++){
			int did=random.nextInt(4);
			if(did==0) {
				did++;
			}
			//System.out.println("did====="+did);
			String uid = UUID.randomUUID().toString().substring(0,5)+i;
			if(did==1){
				mapper.insertSelective(new Employee(null,uid, "M", uid+"@qq.com", did));
				System.out.println("第"+i+"次");
			}
			else{
				mapper.insertSelective(new Employee(null,uid, "W", uid+"@qq.com", did));
				System.out.println("第"+i+"次");
			}

		}
		System.out.println("批量完成");
		
	}

}
