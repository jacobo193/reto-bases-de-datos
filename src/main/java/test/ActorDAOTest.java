package test;
import datos.ActorJDBC;
import domain.ActorDTO;

import java.util.List;

class ActorDAOTest {
    public static void main(String[] args) {
        ActorJDBC actorDAO = new ActorJDBC();
        List<ActorDTO> actors;
        actors = ActorJDBC.seleccionar();
        for(ActorDTO actor: actors) System.out.println("Actores =" + actor);

    }
}