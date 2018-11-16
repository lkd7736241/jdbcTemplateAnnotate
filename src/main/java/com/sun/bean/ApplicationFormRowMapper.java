package com.sun.bean;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * create by qiulisun on 2018/11/16.<br>
 */
@Component
public class ApplicationFormRowMapper implements RowMapper<ApplicationForm> {

    @Override
    public ApplicationForm mapRow(ResultSet rs, int rowNum) throws SQLException {
        ApplicationForm applicationForm = new ApplicationForm();
        applicationForm.setId(rs.getLong("id"));
        applicationForm.setName(rs.getString("name"));
        applicationForm.setQq(rs.getString("qq"));
        applicationForm.setType(rs.getString("type"));
        applicationForm.setAdmissionTime(rs.getLong("admission_time"));
        applicationForm.setGraduateSchool(rs.getString("graduate_school"));
        applicationForm.setStudentIdOnWeb(rs.getString("studentIdOnWeb"));
        applicationForm.setDailyLink(rs.getString("daily_link"));
        applicationForm.setSlogan(rs.getString("slogan"));
        applicationForm.setBrother(rs.getString("brother"));
        applicationForm.setMessageChannel(rs.getString("message_channel"));
        applicationForm.setCreateAt(rs.getLong("create_at"));
        applicationForm.setUpdateAt(rs.getLong("update_at"));
        return applicationForm;
    }
}
