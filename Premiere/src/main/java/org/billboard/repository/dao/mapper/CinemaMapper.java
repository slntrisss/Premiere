package org.billboard.repository.dao.mapper;
import org.billboard.model.db.Cinema;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CinemaMapper implements RowMapper<Cinema> {
    @Override
    public Cinema mapRow(ResultSet resultSet, int i) throws SQLException {
        Cinema cinema = new Cinema();
        cinema.setId(resultSet.getInt("cinema_id"));
        cinema.setName(resultSet.getString("cinema_name"));
        cinema.setAddress(resultSet.getString("address"));
        Blob blob = resultSet.getBlob("image_file");
        return cinema;
    }
}
