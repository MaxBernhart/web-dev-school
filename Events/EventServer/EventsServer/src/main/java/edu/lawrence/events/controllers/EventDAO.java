package edu.lawrence.events.controllers;

import edu.lawrence.events.data.EventRowMapper;
import edu.lawrence.events.objects.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EventDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Event findById(int id) {
	String sql = "SELECT * FROM events WHERE id=?";
        RowMapper<Event> rowMapper = new EventRowMapper();
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
}