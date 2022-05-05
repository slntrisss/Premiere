package org.billboard.repository.dao.daoImpl;

import org.billboard.model.db.TicketType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TicketTypeRepository {
    private final JdbcTemplate jdbcTemplate;

    public TicketTypeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(TicketType ticketType, int scheduleId){
        String sql = "INSERT INTO ticket_type VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql, ticketType.getAdultTicket(),
                ticketType.getYouthTicket(), ticketType.getStudentTicket(),
                scheduleId);
    }
}
