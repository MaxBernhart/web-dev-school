package edu.lawrence.events.data;

import edu.lawrence.events.objects.Event;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EventRowMapper implements RowMapper<Event> {
    @Override
    public Event mapRow(ResultSet row, int rowNum) throws SQLException {
        Event e = new Event();
        e.setId(row.getInt("id"));
        e.setTitle(row.getString("title"));
        e.setTime(row.getString("time"));
        e.setPlace(row.getString("place"));
        e.setDescription(row.getString("description"));
        return e;
    }
}