package kr.or.bit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import kr.or.bit.dao.Empdao;
import kr.or.bit.dto.Dept;
import kr.or.bit.dto.Emp;

@Controller
public class AjaxController {
	
	private View jsonview;

	@Autowired
	public void setJsonview(View jsonview) {
		this.jsonview = jsonview;
	}
	
	private SqlSession sqlsession;
	
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	@RequestMapping(value="empSeleteEmpno.htm")
	public View selectEmpno(String empno, ModelMap map) {
		System.out.println(empno);
		
		Empdao empdao = sqlsession.getMapper(Empdao.class);
		Emp emp = empdao.getEmpListEmpno(empno);
		System.out.println(emp);
		 
		List<Emp> list = new ArrayList<Emp>();
		list.add(emp);
		
		map.addAttribute("data", list);
		
		return jsonview;
	}
	
	
	
	@RequestMapping(value="empSeleteDeptno.htm")
	public View selectDeptno(String deptno, ModelMap map) {
		System.out.println(deptno);
		
		Empdao empdao = sqlsession.getMapper(Empdao.class);
		List<Emp> list = empdao.getEmpListDeptno(deptno);
		
		map.addAttribute("data", list);
		
		return jsonview;
	}
	
	@RequestMapping(value="empSalChart.htm")
	public View empSalChart(ModelMap map) {
		Empdao empdao = sqlsession.getMapper(Empdao.class);
		List<Emp> list = empdao.getEmpListChart();
		
		map.addAttribute("data", list);
		
		return jsonview;
	}
	
}
