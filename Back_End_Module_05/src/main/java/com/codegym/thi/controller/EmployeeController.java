package com.codegym.thi.controller;

import com.codegym.thi.dto.BranchDto;
import com.codegym.thi.dto.EmployeeDto;
import com.codegym.thi.service.IBranchService;
import com.codegym.thi.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IBranchService branchService;

    @GetMapping()
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<EmployeeDto> employeeDtos = employeeService.getAll();
        List<BranchDto> branchDtos = branchService.getAll();
        modelAndView.addObject("branchDtos", branchDtos);
        modelAndView.addObject("employeeDtos", employeeDtos);
        return modelAndView;
    }

    @GetMapping("/branch/{id}")
    public ModelAndView getEmployeeByBranchId(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("list");
        List<BranchDto> branchDtos = branchService.getAll();
        List<EmployeeDto> employeeDtos = employeeService.getEmployeeByBranchId(id);
        modelAndView.addObject("branchDtos", branchDtos);
        modelAndView.addObject("employeeDtos", employeeDtos);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getForm(){
        ModelAndView modelAndView = new ModelAndView("form");
        List<BranchDto> branchDtos = branchService.getAll();
        modelAndView.addObject("branchDtos", branchDtos);
        modelAndView.addObject("employeeDto", new EmployeeDto());
        return modelAndView;
    }

    @GetMapping("/{id}/view")
    public ModelAndView getView(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("view");
        List<BranchDto> branchDtos = branchService.getAll();
        modelAndView.addObject("branchDtos", branchDtos);
        EmployeeDto employeeDto = employeeService.getById(id);
        modelAndView.addObject("employeeDto", employeeDto);
        return modelAndView;
    }


    @GetMapping("/{id}")
    public ModelAndView getById(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        EmployeeDto employeeDto = employeeService.getById(id);
        List<BranchDto> branchDtos = branchService.getAll();
        modelAndView.addObject("branchDtos", branchDtos);
        modelAndView.addObject("employeeDto", employeeDto);
        return modelAndView;
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employeeDto") EmployeeDto employeeDto, RedirectAttributes redirectAttributes) {
        employeeService.addEmployee(employeeDto);
        String message = "Thêm thành công";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/employee";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employeeDto") EmployeeDto employeeDto, RedirectAttributes redirectAttributes) {
        employeeService.addEmployee(employeeDto);
        String message = "Cập nhật thành công";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/employee";
    }

    @GetMapping("/{id}/delete")
    public String deleteEmployee(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        employeeService.deleteEmployee(id);
        String message = "Xóa thành công";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/employee";
    }
}
