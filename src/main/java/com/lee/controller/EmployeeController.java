package com.lee.controller;

import com.lee.entity.Employee;
import com.lee.service.EmployeeService;
import com.lee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lee.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;


    @RequestMapping("/queryAll")
    @ResponseBody
    public Map<String,Object> queryAll(@RequestParam("page") Integer currentPage, @RequestParam("rows") Integer pageSize){
        return employeeService.queryAll(currentPage,pageSize);
    }

    @RequestMapping("/addEmp")
    @ResponseBody
    public boolean addEmp(Employee employee){
        return employeeService.addEmpl(employee);
    }

    @RequestMapping("/delEmp")
    @ResponseBody
    public boolean deleteEmp(String id){
        return employeeService.deleteEmp(id);
    }

    @RequestMapping("/mistySelect")
    @ResponseBody
    public Map<String,Object> mistySelect(String name,String value,Integer page,Integer rows){
        return employeeService.mistySelect(name,value,page,rows);
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request,String name, String password){
        User user = userService.login(name, password);
        request.getSession().setAttribute("user",user);
        return "forward:/index.jsp";
    }
}
