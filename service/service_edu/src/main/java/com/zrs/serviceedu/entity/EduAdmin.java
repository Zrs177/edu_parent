package com.zrs.serviceedu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "edu_admin")
public class EduAdmin {
    private String userName;
    private String password;
    private Date createTime;
    private Date updateTime;
}
