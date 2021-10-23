package com.management.Controller;

import com.management.Entity.Employee;
import com.management.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeServices service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Employee> listemployee = service.listAll();
        model.addAttribute("listemployee", listemployee);
        System.out.print("Get / ");
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("employee", new Employee());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee emp) {
        service.save(emp);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditEmployeePage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("new");
        Employee emp = service.get(id);
        mav.addObject("employee", emp);
        return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deleteEmployeePage(@PathVariable(name = "id") long id) {
        service.delete(id);
        return "redirect:/";
    }
}
