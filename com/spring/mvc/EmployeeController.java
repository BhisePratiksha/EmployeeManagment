package com.spring.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.jdbc.Employee;
import com.spring.jdbc.EmployeeDao;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeDao empDao;
	
	@GetMapping("/employee")
	public ModelAndView displayEmployee(Model model) {
		List<Employee> employeeList = empDao.getEmployees();
		model.addAttribute("employeeList", employeeList);
		return new ModelAndView("employee", "employee", new Employee());
	}
	
	@PostMapping("/employee")
	public ModelAndView saveEmployee(@ModelAttribute("employee") @Valid Employee employee,
			BindingResult bindingResult,
			Model model) {
		//TODO save the emp
				List<Employee> employeeList = empDao.getEmployees();
				model.addAttribute("employeeList", employeeList);
		if(bindingResult.hasErrors()) {
			return new ModelAndView("employee", "employee", employee);
		}
		
		System.out.println(employee);
		
		return new ModelAndView("employee", "employee", new Employee());
	}
	
	@GetMapping("/employee/delete")
	public String deleteEmployee(@RequestParam("empId") String empId) {
		System.out.println("Deleting emp with empID:"+empId);
		int count = empDao.deleteEmployee(empId);
		System.out.println("Count:"+count);
		
		return "redirect:/employee";
	} 
	
	@GetMapping("/employee/edit/{empId}")
	public ModelAndView editEmployee(@PathVariable String empId, Model model) {
		List<Employee> employeeList = empDao.getEmployees();
		model.addAttribute("employeeList", employeeList);
		
		Employee employee = empDao.getEmployee(empId);
		
		return new ModelAndView("employee", "employee", employee);
	}
	
	@ModelAttribute("depts")
	public List<String> getDepts() {
		List<String> depts = new ArrayList<String>();
		depts.add("IT");
		depts.add("HR1");
		depts.add("Sales");
		depts.add("ADMIN");
		
		return depts;
	}
}
