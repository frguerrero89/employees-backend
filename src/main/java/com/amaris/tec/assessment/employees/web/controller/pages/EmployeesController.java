package com.amaris.tec.assessment.employees.web.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller created to render the index page created with angular.
 */
@Controller
public class EmployeesController {

    /**
     * Returns the template name.
     * 
     * @return returns temaplate name
     */
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

}
