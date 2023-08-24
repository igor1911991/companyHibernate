package com.example.companyHibernate.controller;

import com.example.companyHibernate.domain.Role;
import com.example.companyHibernate.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping()
    public String showRoles(Model model) {

        model.addAttribute("roles", roleService.listRole());
        model.addAttribute("newRole", new Role());

        return "role";
    }

    @PostMapping("/add_role")
    public String addRole(@ModelAttribute("newRole") Role role) {

        roleService.addRole(role);

        return "redirect:/role";
    }

    @DeleteMapping("/delete_role")
    public String deleteRole(@ModelAttribute("roleId") Long id) {

        roleService.removeRole(id);

        return "redirect:/role";
    }



    //TODO remeke
    @PostMapping("/update_role")
    public String updateRole(@ModelAttribute("roleId") Long roleId, Model model) {


        return "updateEmployee";
    }
}
