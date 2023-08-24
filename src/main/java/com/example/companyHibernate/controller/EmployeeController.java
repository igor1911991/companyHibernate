package com.example.companyHibernate.controller;

import com.example.companyHibernate.domain.Employee;
import com.example.companyHibernate.domain.Role;
import com.example.companyHibernate.service.EmployeeService;
import com.example.companyHibernate.service.ProjectService;
import com.example.companyHibernate.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final RoleService roleService;
    private final ProjectService projectService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, RoleService roleService, ProjectService projectService) {
        this.employeeService = employeeService;
        this.roleService = roleService;
        this.projectService = projectService;
    }

    @GetMapping()
    public String showEmployees(Model model) {

        model.addAttribute("employees", employeeService.listEmployees());
        model.addAttribute("newEmployee", new Employee());

        return "employee";
    }

    @PostMapping("/add_employee")
    public String addEmployee(@ModelAttribute("newEmployee") Employee employee) {

        employeeService.addEmployee(employee);

        return "redirect:/employee";
    }

    @DeleteMapping("/delete_employee")
    public String deleteEmployee(@ModelAttribute("employeeId") Long id) {

        employeeService.removeEmployee(id);

        return "redirect:/employee";
    }


    //TODO remake
    @PostMapping("/update_employee")
    public String updateEmployee(@ModelAttribute("employeeId") Long employeeId, Model model) {

        Employee employee = employeeService.getEmployee(employeeId);
        System.out.println(employee.getId() + " " + employee.getName());
        List<Role> roles = roleService.listRole();
        model.addAttribute("employee", employee);
        model.addAttribute("roles", roles);
        model.addAttribute("changeEmployee", new Employee());

        return "updateEmployee";
    }

    //TODO remake
    @PostMapping("/changeEmployee")
    public String changeEmployee(@ModelAttribute("changeEmployee") Employee employee, Model model) {

        System.out.println(employee.getId());

        return "redirect:/employee";
    }

}
