package com.zrs.serviceedu.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrs.serviceedu.entity.EduTeacher;
import com.zrs.serviceedu.entity.vo.TeacherVo;
import com.zrs.serviceedu.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import servicebase.R;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zrs
 * @since 2022-11-16
 */
@RestController
@RequestMapping("/service/teacher")
@CrossOrigin
public class EduTeacherController {
    @Autowired
    private EduTeacherService teacherService;

    @GetMapping("findAll")
    private R findAllTeacher(){
        List<EduTeacher> list = teacherService.list(null);
        return R.success().data("data",list);
    }
    @GetMapping("getTeacher/{id}")
    private R getById(@PathVariable String id){
        EduTeacher teacher = teacherService.getById(id);
        return R.success().data("data",teacher);
    }
    @DeleteMapping("deleteById/{id}")
    private R deleteById(@PathVariable String id){
       if (teacherService.removeById(id)){
           return R.success();
       }else {
           return R.error();
       }
    }
    @PutMapping("updateTeacher")
    private R updateById(@RequestBody EduTeacher eduTeacher){
        return teacherService.updateById(eduTeacher)?R.success():R.error();
    }
    @PostMapping ("getPage/{current}/{limit}")
    private R getPage(@PathVariable Integer current, @PathVariable Integer limit, @RequestBody(required = false) TeacherVo teacherVo){
        return teacherService.getPage(current,limit,teacherVo);
    }
    @PostMapping("saveTeacher")
    private R saveTeacher(@RequestBody EduTeacher teacher){
        return teacherService.save(teacher)?R.success():R.error();
    }

}

