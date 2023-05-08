package edu.lawrence.events.controllers;

import edu.lawrence.events.data.ParticipantRowMapper;
import edu.lawrence.events.objects.Participant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ParticipantDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Participant> findByEvent(int event) {
	String sql = "SELECT * FROM registrations WHERE event=?";
        RowMapper<Participant> rowMapper = new ParticipantRowMapper();
        return jdbcTemplate.query(sql, rowMapper, event);
    }

    public void save(Participant p) {
        String insertSQL = "INSERT INTO registrations (event,name,email) values (?, ?, ?)";
        jdbcTemplate.update(insertSQL,p.getEvent(),p.getName(),p.getEmail());
    }
}