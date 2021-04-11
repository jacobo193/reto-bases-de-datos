package datos;
import domain.ActorDTO;
import org.junit.Test;

import java.util.List;

class ActorDAOTest {
    @Test
    public static void main(String[] args) {
        ActorJDBC actorJDBC = new ActorJDBC();
        List<ActorDTO> actors;
        actors = actorJDBC.select();
        for(ActorDTO actor: actors) System.out.println("Actores =" + actor);

    }
}