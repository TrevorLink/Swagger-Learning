package com.hyy.controller;

import com.hyy.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author HuangSir
 * @date 2021-11-02 15:28
 */
@Controller
@Api(tags = "Hello接口1")
public class HelloController {
   @RequestMapping("/")
   @ResponseBody
   @ApiOperation("HelloWorld测试")
   public String  hello(){
      return "Hello Swagger !";
   }

   @RequestMapping("test")
   @ResponseBody
   @ApiOperation("Test测试")
   public String  test(){
      return  "test";
   }

   @GetMapping("/user/{name}")
   @ApiOperation(value = "返回user实体",notes = "随机返回一个用户实体信息")
   public User user(@ApiParam(value = "用户名",required = true )
                               @PathVariable("name") String name){
      return  new User();
   }
}
