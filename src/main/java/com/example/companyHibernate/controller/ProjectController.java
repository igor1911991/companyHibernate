package com.example.companyHibernate.controller;

import com.example.companyHibernate.domain.Project;
import com.example.companyHibernate.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String showProjects(Model model) {

        model.addAttribute("projects", projectService.listProject());
        model.addAttribute("newProject", new Project());

        return "project";
    }

    @PostMapping("/add_project")
    public String addProject(@ModelAttribute("newProject") Project project) {

        projectService.addProject(project);

        return "redirect:/project";
    }

    @DeleteMapping("/delete_project")
    public String deleteProject(@ModelAttribute("projectId") Long id) {

        projectService.removeProject(id);

        return "redirect:/project";
    }



    //TODO remeke
    @PostMapping("/update_role")
    public String updateProject(@ModelAttribute("roleId") Long roleId, Model model) {



        return "updateEmployee";
    }
}
