package org.billboard.repository.dao.mapper;

import org.billboard.model.db.CinemaInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CinemaInfoMapper implements RowMapper<CinemaInfo> {
    @Override
    public CinemaInfo mapRow(ResultSet resultSet, int i) throws SQLException {
        CinemaInfo cinema = new CinemaInfo();
        cinema.setId(resultSet.getInt("cinema_id"));
        cinema.setAddress(resultSet.getString("address"));
        cinema.setName(resultSet.getString("cinema_name"));
        cinema.setStartOfWork(resultSet.getString("start_of_work"));
        cinema.setEndOfWork(resultSet.getString("end_of_work"));
        cinema.setNumberOfHalls(resultSet.getInt("number_of_halls"));
        cinema.setPhone(resultSet.getString("phone"));
        cinema.setCinemaInfo(resultSet.getString("cinema_info"));
        return cinema;
    }
}
