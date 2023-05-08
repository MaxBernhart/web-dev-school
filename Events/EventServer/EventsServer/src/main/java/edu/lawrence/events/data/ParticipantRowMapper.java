package edu.lawrence.events.data;

import edu.lawrence.events.objects.Participant;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ParticipantRowMapper implements RowMapper<Participant> {
    @Override
    public Participant mapRow(ResultSet row, int rowNum) throws SQLException {
        Participant p = new Participant();
        p.setId(row.getInt("id"));
        p.setEvent(row.getInt("event"));
        p.setName(row.getString("name"));
        p.setEmail(row.getString("email"));
        return p;
    }
}