/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnnd.controllers;

import com.lnnd.service.TransactionService;
import com.lnnd.service.TypeTransactionService;
import java.util.Map;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ADMIN
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class IndexController {

    @Autowired
    private TypeTransactionService typeTransactionService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private Environment env;
    int pageSize = 5;

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("type", this.typeTransactionService.getTypeTransaction());
    }

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

}
