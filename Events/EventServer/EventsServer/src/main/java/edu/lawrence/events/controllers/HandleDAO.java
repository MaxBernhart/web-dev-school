package edu.lawrence.events.controllers;

import edu.lawrence.events.data.HandleRowMapper;
import edu.lawrence.events.objects.Handle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class HandleDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Handle> findAll() {
	String sql = "SELECT id, title FROM events";
        RowMapper<Handle> rowMapper = new HandleRowMapper();
        return jdbcTemplate.query(sql, rowMapper);
    }

}

