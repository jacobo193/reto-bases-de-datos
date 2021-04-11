package datos;

import domain.ActorDTO;

import java.sql.SQLException;
import java.util.List;

public interface ActorDao {
    public List<ActorDTO> select() throws SQLException;

}
