package com.sun.dao;

import com.sun.bean.ApplicationForm;

/**
 * create by qiulisun on 2018/11/15.<br>
 */
public interface ApplicationFormDao {

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    ApplicationForm selectApplicationFormById(long id);

    /**
     * 根据姓名查找
     * @param name
     * @return
     */
    ApplicationForm selectApplicationFormByName(String name);

    /**
     *
     * @param qq
     * @return
     */
    ApplicationForm selectApplicationFormByQQ(String qq);

    /**
     * 添加报名表
     * @param applicationForm
     * @return
     */
    boolean addForm(ApplicationForm applicationForm);

    /**
     * 根据ID删除
     * @param applicationForm
     * @return
     */
    boolean deleteForm(ApplicationForm applicationForm);

    /**
     * 根据ID更改
     * @param applicationForm
     * @return
     */
    boolean updateForm(ApplicationForm applicationForm);
}
