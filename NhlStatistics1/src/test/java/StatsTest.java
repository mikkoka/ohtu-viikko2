/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mikko
 */
public class StatsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Staatistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void searchFindsPlayer() {
        Player jari = stats.search("Kurri");
        assertEquals(jari.getName(), "Kurri");

    }

    @Test
    public void searchReturnsNullForNonExistent() {
        Player jari = stats.search("Korri");
        assertEquals(jari == null, true);
    }

    @Test
    public void teamReturnsPlayersOfTeam() {
        Player jari = stats.search("Kurri");
        Player wayne = stats.search("Gretzky");
        Player al = stats.search("Semenko");
        List<Player> oilers = stats.team("EDM");
        assertEquals((oilers.contains(jari) && oilers.contains(wayne) && oilers.contains(al)), true);
    }
    
    @Test
    public void topScorersReturnsTopScorers() {
        Player wayne = stats.search("Gretzky");
        Player mario = stats.search("Lemieux");
        Player steve = stats.search("Yzerman");
        List<Player> top = stats.topScorers(2);
        assertEquals((top.contains(wayne) && top.contains(mario)), true);
    }
}
