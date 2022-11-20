package com.zrs.serviceedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrs.serviceedu.entity.EduTeacher;
import com.zrs.serviceedu.entity.vo.TeacherVo;
import com.zrs.serviceedu.mapper.EduTeacherMapper;
import com.zrs.serviceedu.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import servicebase.R;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zrs
 * @since 2022-11-16
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public R getPage(Integer current, Integer limit, TeacherVo teacherVo) {
        Page<EduTeacher> page= new Page<>(current,limit);
        QueryWrapper queryWrapper=new QueryWrapper<>();
        if (teacherVo!=null){
            String name = teacherVo.getName();
            queryWrapper.like(!StringUtils.isEmpty(name),"name",name);
            Integer level = teacherVo.getLevel();
            queryWrapper.like(!StringUtils.isEmpty(level),"level",level);
            String begin = teacherVo.getBegin();
            queryWrapper.ge(!StringUtils.isEmpty(begin),"gmt_create",begin);
            String end = teacherVo.getEnd();
            queryWrapper.le(!StringUtils.isEmpty(end),"gmt_create",end);
        }
        queryWrapper.orderByDesc("gmt_create");
        page(page,queryWrapper);
        return R.success().data("data",page.getRecords()).data("total",page.getTotal());
    }
}
