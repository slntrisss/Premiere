package org.billboard.repository.dao.daoImpl;

import org.billboard.model.db.RoleDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}