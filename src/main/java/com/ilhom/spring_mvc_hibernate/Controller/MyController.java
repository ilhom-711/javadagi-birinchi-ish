package com.ilhom.spring_mvc_hibernate.Controller;


import com.ilhom.spring_mvc_hibernate.dao.EmployeeDAOImpl;
import com.ilhom.spring_mvc_hibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private EmployeeDAOImpl employeeDAO;


    @RequestMapping("/")
     public String showAllEmployees(Model model){

        List<Employee> allEmployees= employeeDAO.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
     }
    @RequestMapping("/addNewEmployee")
     public String addNewEmployee(Model model){

        Employee employee= new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
     }

     @RequestMapping("/saveEmployee")
    public  String saveEmployee(@ModelAttribute("employee") Employee employee){

        employeeDAO.saveEmployee(employee);
         return "redirect:/";
     }

     @RequestMapping("/updateInfo")
     public  String updateEmployee(@RequestParam("empId") int id, Model model ){
        Employee employee= employeeDAO.getEmployee(id);
        model.addAttribute("employee", employee);

        return "employee-info";
     }
        @RequestMapping("/deleteEmployee")
     public String deleteEmployee(@RequestParam("empId") int id){

        employeeDAO.deleteEmployee(id);
        return "redirect:/";

        }
}
