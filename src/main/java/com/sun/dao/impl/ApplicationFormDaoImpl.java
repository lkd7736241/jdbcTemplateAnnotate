package com.sun.dao.impl;

import com.sun.bean.ApplicationForm;
import com.sun.bean.ApplicationFormRowMapper;
import com.sun.dao.ApplicationFormDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    /**
     * 插入数据
     * 不返回插入的自增长ID
     * @param applicationForm
     * @return
     */
//    @Override
//    public boolean addForm(ApplicationForm applicationForm) {
//        String sql = "INSERT INTO application_form ( name, qq, type, admission_time, graduate_school, studentIdOnWeb, " +
//                "daily_link, slogan, brother, message_channel, create_at, update_at ) " +
//                "VALUES " +
//                "(?,?,?,?,?,?,?,?,?,?,?,?)";
//
//        Object[] objects = {applicationForm.getName(), applicationForm.getQq(), applicationForm.getType(),
//                applicationForm.getAdmissionTime(), applicationForm.getGraduateSchool(), applicationForm.getStudentIdOnWeb(),
//                applicationForm.getDailyLink(), applicationForm.getSlogan(), applicationForm.getBrother(),
//                applicationForm.getMessageChannel(), applicationForm.getCreateAt(), applicationForm.getUpdateAt()};
//        int count = jdbcTemplate.update(sql, objects);
//        return count;
//    }

    /**
     * 插入数据
     * 返回插入数据的ID
     * @param applicationForm
     * @return
     */
    @Override
    public long addForm(final ApplicationForm applicationForm) {
        final String sql = "INSERT INTO application_form ( name, qq, type, admission_time, graduate_school, studentIdOnWeb, " +
                    "daily_link, slogan, brother, message_channel, create_at, update_at ) " +
                    "VALUES " +
                    "(?,?,?,?,?,?,?,?,?,?,?,?)";
        KeyHolder holder = new GeneratedKeyHolder();

        final String[] columnNames = {"name", "qq", "type", "admission_time", "graduate_school", "studentIdOnWeb", "daily_link",
                                "slogan", "brother", "message_channel", "create_at", "update_at"};

        int count = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql, columnNames);
                ps.setString(1, applicationForm.getName());
                ps.setString(2, applicationForm.getQq());
                ps.setString(3, applicationForm.getType());
                ps.setLong(4, applicationForm.getAdmissionTime());
                ps.setString(5, applicationForm.getGraduateSchool());
                ps.setString(6, applicationForm.getStudentIdOnWeb());
                ps.setString(7, applicationForm.getDailyLink());
                ps.setString(8, applicationForm.getSlogan());
                ps.setString(9, applicationForm.getBrother());
                ps.setString(10, applicationForm.getMessageChannel());
                ps.setLong(11, applicationForm.getCreateAt());
                ps.setLong(12, applicationForm.getUpdateAt());
                return ps;
            }
        }, holder);
        if (count > 0) {
            return holder.getKey().intValue();
        } else {
            return -1;
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
