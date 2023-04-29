package com.example.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @Author: shlin
 * @Date: 2023/4/27 - 04 - 27 - 15:58
 * @Description: com.example.controller
 * @Version: 1.0
 */
@Controller
public class TestController {

    //@ResponseBody
    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        //获取请求数据
        System.out.println(request.getMethod()); // GET
        System.out.println(request.getServletPath()); //  /http
        Enumeration<String> enumeration = request.getHeaderNames(); //请求头 返回的是迭代器对象
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();//获得的是key
            String value = request.getHeader(name);
            System.out.println(name+" "+value);
        }
        System.out.println(request.getParameter("code"));//如果有请求字段 可以直接通过参数获得

        //向浏览器 返回相应数据
        response.setContentType("text/html;charset=utf-8");//返回数据的类型 网页
        try(
                PrintWriter writer = response.getWriter();
        ){
            writer.write("<h1>牛客网<h1>");//可以这样向输出流写入网页数据，但实际中不会这么写
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //get请求 向服务器获取某些数据 获取参数的两种方式，一个是student?code=123  另一个是直接将参数放到路径中student/123
    // /students?current=1&limit=20

    @RequestMapping(path="/students",method = RequestMethod.GET)//如果没指定 get和post都可以去处理，就可能存在漏洞
    @ResponseBody //就可以在网页中直接返回字符串 不用视图解析器
    public String getStudents(
            @RequestParam(name = "current",required = false, defaultValue =  "1") int current,//如果没有@RequestParam字段，current和请求字段相同的名字也可以
            @RequestParam(name = "limit",required = false, defaultValue =  "10")int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    // /student/123
    @RequestMapping(path="/student/{id}",method = RequestMethod.GET)//从路径中获取参数
    @ResponseBody
    public String getStudent(@PathVariable("id") int sid){//从路径中的id字段赋值给 sid
        System.out.println(sid);
        return "a student";
    }

    //post请求  get请求只能在明面路径上添加参数 而且路径长度也有限制，所以一般要在表单中 post请求
    @RequestMapping(path="/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age){//只要和表单中name属性的值一样就可以获取到，不一样也用@RequestParam
        System.out.println(name);
        System.out.println(age);
        return "student";
    }

    //响应html数据
    @RequestMapping(path="/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){//响应的是动态html 需要由视图解析器去动态解析
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","shlin");
        modelAndView.addObject("age",30);
        modelAndView.setViewName("/demo/view");//要在对应的templates文件夹下面的
        return modelAndView;

    }

    @RequestMapping(path="/school", method = RequestMethod.GET)//效果和上面是一样的，更简洁，建议使用
    public String getSchool(Model model){
        model.addAttribute("name","北京大学");
        model.addAttribute("age",80);
        return "/demo/view";
    }

    // 响应json数据， 常用于异步请求中 当前网页不刷新，但是数据访问了数据库
    //java对象 -> JSON字符串 -> JS对象
    @RequestMapping(path="/emp", method = RequestMethod.GET)
    @ResponseBody //加了之后才能允许返回json字符串 否则就是默认modelandview
    public Map<String, Object> getEmp(){
        Map<String, Object> emp = new LinkedHashMap<>();
        emp.put("name","shlin");
        emp.put("age",22);
        emp.put("salary",8000);
        return emp;  //会在网页中返回 {"name":"shlin","age":22,"salary":8000}
    }

    @RequestMapping(path="/emps", method = RequestMethod.GET)
    @ResponseBody //加了之后才能允许返回json字符串 否则就是默认modelandview
    public List<Map<String, Object>> getEmps(){
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> emp = new LinkedHashMap<>();
        emp.put("name","shlin");
        emp.put("age",22);
        emp.put("salary",8000);
        list.add(emp);

        Map<String, Object> emp2 = new LinkedHashMap<>();
        emp2.put("name","shi");
        emp2.put("age",21);
        emp2.put("salary",8000);
        list.add(emp2);

        return list;  //会在网页中返回 [{"name":"shlin","age":22,"salary":8000},{"name":"shi","age":21,"salary":8000}]
    }



}
