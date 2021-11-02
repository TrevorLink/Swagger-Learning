package com.hyy.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author HuangSir
 * @date 2021-11-02 19:22
 */
@ApiModel("用户类")
public class User {
   @ApiModelProperty("用户名")
   public String name;
   @ApiModelProperty("密码")
   public String password;
   @ApiModelProperty("用户编号（唯一）")
   public int id;
}
