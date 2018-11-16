package com.sun.dao.impl;

import com.sun.bean.ApplicationForm;
import com.sun.bean.ApplicationFormRowMapper;
import com.sun.dao.ApplicationFormDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * create by qiulisun on 2018/11/15.<br>
 */
@Repository
public class ApplicationFormDaoImpl implements ApplicationFormDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ApplicationFormRowMapper applicationFormRowMapper;

    @Override
    public ApplicationForm selectApplicationFormById(long id) {
        String sql = "SELECT " +
                "id," +
                "name," +
                "qq," +
                "type," +
                "admission_time," +
                "graduate_school," +
                "studentIdOnWeb," +
                "daily_link," +
                "slogan," +
                "brother," +
                "message_channel," +
                "create_at," +
                "update_at " +
                "FROM " +
                "application_form " +
                "WHERE " +
                "id = ?" ;
        Object[] objects = {id};
        ApplicationForm form = jdbcTemplate.queryForObject(sql, objects, applicationFormRowMapper);
        return form;
    }

    @Override
    public ApplicationForm selectApplicationFormByName(String name) {
        String sql = "SELECT " +
                "id," +
                "name," +
                "qq," +
                "type," +
                "admission_time," +
                "graduate_school," +
                "studentIdOnWeb," +
                "daily_link," +
                "slogan," +
                "brother," +
                "message_channel," +
                "create_at," +
                "update_at " +
                "FROM " +
                "application_form " +
                "WHERE " +
                "name = ?" ;
        Object[] objects = {name};
        ApplicationForm form = jdbcTemplate.queryForObject(sql, objects, applicationFormRowMapper);
        return form;
    }

    @Override
    public ApplicationForm selectApplicationFormByQQ(String qq) {
        String sql = "SELECT " +
                "id," +
                "name," +
                "qq," +
                "type," +
                "admission_time," +
                "graduate_school," +
                "studentIdOnWeb," +
                "daily_link," +
                "slogan," +
                "brother," +
                "message_channel," +
                "create_at," +
                "update_at " +
                "FROM " +
                "application_form " +
                "WHERE " +
                "qq = ?" ;
        Object[] objects = {qq};
        ApplicationForm form = jdbcTemplate.queryForObject(sql, objects, applicationFormRowMapper);
        return form;
    }

    @Override
    public boolean addForm(ApplicationForm applicationForm) {
        String sql = "INSERT INTO application_form ( name, qq, type, admission_time, graduate_school, studentIdOnWeb, " +
                "daily_link, slogan, brother, message_channel, create_at, update_at ) " +
                "VALUES " +
                "(?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] objects = {applicationForm.getName(), applicationForm.getQq(), applicationForm.getType(),
                applicationForm.getAdmissionTime(), applicationForm.getGraduateSchool(), applicationForm.getStudentIdOnWeb(),
                applicationForm.getDailyLink(), applicationForm.getSlogan(), applicationForm.getBrother(),
                applicationForm.getMessageChannel(), applicationForm.getCreateAt(), applicationForm.getUpdateAt()};
        int count = jdbcTemplate.update(sql, objects);
        if (count > 0) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteForm(ApplicationForm applicationForm) {
        String sql = "DELETE FROM application_form WHERE id = ?;";
        Object[] objects = {applicationForm.getId()};
        int count = jdbcTemplate.update(sql, objects);
        if (count > 0) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateForm(ApplicationForm applicationForm) {
        String sql = "UPDATE application_form " +
                "SET name = ?," +
                " qq = ?," +
                " type = ?," +
                " admission_time = ?," +
                " graduate_school = ?," +
                " studentIdOnWeb = ?," +
                " daily_link = ?," +
                " slogan = ?," +
                " brother = ?," +
                " message_channel = ?," +
                " create_at = ?," +
                " update_at = ?" +
                " WHERE" +
                " id = ?;";
        Object[] params = {applicationForm.getName(), applicationForm.getQq(), applicationForm.getType(),
                applicationForm.getAdmissionTime(), applicationForm.getGraduateSchool(), applicationForm.getStudentIdOnWeb(),
                applicationForm.getDailyLink(), applicationForm.getSlogan(), applicationForm.getBrother(),
                applicationForm.getMessageChannel(), applicationForm.getCreateAt(), applicationForm.getUpdateAt(),
                applicationForm.getId()};
        int count = jdbcTemplate.update(sql, params);
        if (count > 0) {
            return true;
        }else {
            return false;
        }
    }

}
