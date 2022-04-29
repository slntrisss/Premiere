package org.billboard.repository.dao.daoImpl;

import org.billboard.model.db.RoleDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoleDetailRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RoleDetailRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<RoleDetail> findRoleDetails(int ID){
        String sql = "SELECT role_id, role_name, role_surname, role_type " +
                "FROM role_detail WHERE detail_id=? order by role_type";
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(RoleDetail.class), ID);
    }

    public void save(List<RoleDetail> roleDetails, int ID){
        String sql = "INSERT INTO ROLE_DETAIL VALUES(role_detail_id_seq.nextval, ?, ?, ?, ?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, roleDetails.get(i).getRoleName());
                preparedStatement.setString(2, roleDetails.get(i).getRoleSurname());
                preparedStatement.setString(3, roleDetails.get(i).getRoleType());
                preparedStatement.setInt(4, ID);
            }

            @Override
            public int getBatchSize() {
                return roleDetails.size();
            }
        });
    }

    public void update(List<RoleDetail> roleDetails, int detailId){
        String proc_call = "call DB.update_role_detail_by_id(?,?,?,?,?)";
        jdbcTemplate.batchUpdate(proc_call, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1,roleDetails.get(i).getRoleId());
                preparedStatement.setString(2,roleDetails.get(i).getRoleName());
                preparedStatement.setString(3,roleDetails.get(i).getRoleSurname());
                preparedStatement.setString(4,roleDetails.get(i).getRoleType());
                preparedStatement.setInt(5,detailId);
            }

            @Override
            public int getBatchSize() {
                return roleDetails.size();
            }
        });
    }

    public void delete(int ID){
        String sql = "DELETE FROM role_detail WHERE role_id=?";
        jdbcTemplate.update(sql, ID);
    }
}