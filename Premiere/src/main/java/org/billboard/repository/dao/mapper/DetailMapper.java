package org.billboard.repository.dao.mapper;

import org.billboard.model.db.Detail;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailMapper implements RowMapper<Detail> {
    @Override
    public Detail mapRow(ResultSet resultSet, int i) throws SQLException {
        Detail detail = new Detail();
        detail.setDetailId(resultSet.getInt("detail_id"));
        detail.setCountry(resultSet.getString("country"));
        detail.setAgeRating(resultSet.getInt("age_rating"));
        detail.setDescription(resultSet.getString("description"));
        detail.setRating(resultSet.getInt("rating"));
        detail.setNumberOfVotes(resultSet.getInt("number_of_votes"));
        detail.setDuration(resultSet.getInt("duration"));
        detail.setReleaseDate(resultSet.getDate("release_date"));
        detail.setLanguage(resultSet.getString("movie_lang"));
        return detail;
    }
}
