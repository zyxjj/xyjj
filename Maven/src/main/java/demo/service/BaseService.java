package demo.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import demo.bean.Dept;
import demo.bean.Emp;
import demo.dao.BaseDao;

@Service("baseservice")
public class BaseService {
	@Resource(name="basedao")
	private BaseDao basedao;
	
	public void add(Object obj){
		basedao.add(obj);
	}
	
	public Object load(Class clazz, Integer id){
		return basedao.load(clazz, id);
	}
	
	public void update(Object obj){
		basedao.update(obj);
	}
	
	public void delete(Object obj){
		basedao.delete(obj);
	}
	
	public List find(String hql){
		return basedao.find(hql);
	}
	
	public static void main(String[] args) {
		ApplicationContext appctx = new ClassPathXmlApplicationContext("/app-core.xml");
		BaseService service = (BaseService)appctx.getBean("baseservice");
		
//		Dept dept = new Dept();
//		dept.setDname("行政部");
		
//		service.add(dept);
		Emp emp = new Emp();
		Dept dept = (Dept) service.load(Dept.class, 1);
		emp.setDept(dept);
		emp.setEname("张san");
		emp.setSar(5000F);
		emp.setHire(new Date());
		emp.setSex("M");
//		service.add(emp);
		for(Object obj : service.find("from Emp")){
			System.out.println(obj);
		}
		
	}
	
}
