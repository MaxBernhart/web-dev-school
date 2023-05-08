package edu.lawrence.events.data;

import edu.lawrence.events.objects.Handle;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class HandleRowMapper implements RowMapper<Handle> {
    @Override
    public Handle mapRow(ResultSet row, int rowNum) throws SQLException {
        Handle h = new Handle();
        h.setId(row.getInt("id"));
        h.setTitle(row.getString("title"));
        return h;
    }
}