package com.zrs.serviceedu.service;

import com.zrs.serviceedu.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zrs.serviceedu.entity.vo.TeacherVo;
import servicebase.R;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zrs
 * @since 2022-11-16
 */
public interface EduTeacherService extends IService<EduTeacher> {

    R getPage(Integer current, Integer limit, TeacherVo teacherVo);
}
