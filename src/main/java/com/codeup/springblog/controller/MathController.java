package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @RequestMapping(path = "/add/{x}/and/{y}", method = RequestMethod.GET)
    @ResponseBody
    public int add(@PathVariable int x, @PathVariable int y) {
        return  (x + y);
    }

    @RequestMapping(path = "/subtract/{x}/from/{y}", method = RequestMethod.GET)
    @ResponseBody
    public int subtract(@PathVariable int x, @PathVariable int y) {
        return  (x - y);
    }
    @RequestMapping(path = "/multiply/{x}/and/{y}", method = RequestMethod.GET)
    @ResponseBody
    public int multiply(@PathVariable int x, @PathVariable int y) {
        return  (x*y);
    }
    @RequestMapping(path = "/divide/{x}/by/{y}", method = RequestMethod.GET)
    @ResponseBody
    public int divide(@PathVariable int x, @PathVariable int y) {
        return  (x/y);
    }

}


//        /divide/6/by/3	2