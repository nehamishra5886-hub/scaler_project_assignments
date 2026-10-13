package com.example.Evaluations.evaluation.controller;


import com.example.Evaluations.evaluation.model.Permission;
import com.example.Evaluations.evaluation.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contractualEmployee")
public class ContractualEmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    //Implement APIs here...
    @GetMapping("/isOnboarded/email/{email}")
    public Boolean isOnboarded(
            @PathVariable String email,
            @RequestParam(required = false) Long empId) {
        return employeeService.isOnboarded(empId, email);
    }

    @GetMapping("/permissions")
    public List<Permission> getPermissions(
            @RequestParam List<String> roles) {
        return employeeService.getPermissionsBasedOnRoles(roles);
    }

    @GetMapping
    public Boolean isIdentityProvided(
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String name) {
        return employeeService.isIdentityProvided(email, password, name);
    }
}
/* Notes -
* Key points
- @PathVariable extracts email from the URL path.
- @RequestParam(required = false) makes empId, email, password, and name optional query parameters.
- @RequestParam List<String> roles accepts multiple comma-separated values, such as roles=INSTRUCTOR,TA.
- @GetMapping without a path maps to the class-level route /contractualEmployee.
- Each API delegates its logic to IEmployeeService.
Example requests
API	Request
Check onboarding	/contractualEmployee/isOnboarded/email/test@example.com?empId=10
Get permissions	/contractualEmployee/permissions?roles=INSTRUCTOR,TA
Check identity	/contractualEmployee?email=test@example.com&password=abc&name=Neha
Note: The service determines the Boolean results. For example, isOnboarded returns true only when both empId and email are non-null.*/