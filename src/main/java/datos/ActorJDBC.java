package datos;

import domain.ActorDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorJDBC<actor> {

    private Connection conexionTransacional;
    private static final String SQL_SELECT =  "SELECT actor_id, first_name, last_name FROM jacobo_diaz.actor";
    private static final String SQL_INSERT = "INSERT INTO jacobo_diaz.actor (first_name, last_nam) VALUE (?,?)";


    public static List<ActorDTO> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ActorDTO actor = null;
        List <ActorDTO> actors = new ArrayList<>();


        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT );
            rs = stmt.executeQuery();
            while (rs.next()){
                int actorId = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                actor = new ActorDTO(actorId, firstName, lastName );

                actors.add(actor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                conexion.close(rs);
                conexion.close(stmt);
                conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return actors;
    }
}

