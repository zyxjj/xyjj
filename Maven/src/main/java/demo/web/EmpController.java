package demo.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.bean.Dept;
import demo.bean.Emp;
import demo.service.BaseService;

@Controller
public class EmpController {
	@Resource(name="baseservice")
	private BaseService service;
	
	@RequestMapping(value="/list")
	@ResponseBody
	public Object list(){
		String hql = "select e from Emp e where 1=1";
		
		return service.find(hql);
	}
	
	@RequestMapping(value="/deptlist")
	@ResponseBody
	public Object deptlist(){
		String hql = "from Dept";
		return service.find(hql);
	}
	
	
	@RequestMapping(value="/add")
	@ResponseBody
	public Object add(Emp emp){

		Dept dept = (Dept)service.load(Dept.class, emp.getDeptid());
		emp.setDept(dept);
		
		service.add(emp);

		Map<String,Object> data = new HashMap<String,Object>();
		data.put("result", "OK");
		return data;
		
	}	  
	
	
	 
	
	@RequestMapping(value="/toupdate")
	@ResponseBody
	public Object toupdate(@RequestParam(name="eid") int eid){
		return service.load(Emp.class, eid);
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	public Object update(Emp emp){
		Emp oldemp = (Emp)service.load(Emp.class, emp.getEid());
		
		oldemp.setEname(emp.getEname());
		oldemp.setSex(emp.getSex());
		oldemp.setSar(emp.getSar());
		oldemp.setHire(emp.getHire());
		
		Dept dept = (Dept)service.load(Dept.class, emp.getDeptid());
		oldemp.setDept(dept);

		oldemp.setDeptid(emp.getDeptid());
		

		service.update(oldemp);
	
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("result", "OK");
		return data;
	}

}
