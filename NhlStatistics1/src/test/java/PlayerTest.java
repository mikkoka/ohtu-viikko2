/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ohtuesimerkki.Player;
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
public class PlayerTest {

    Player jkurri;

    @Before
    public void setUp() {
        jkurri = new Player("Kurri", "EDM", 37, 53);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void PlayerReturnsAssists() {
        assertEquals(jkurri.getAssists(), 53);
    }

    @Test
    public void PlayerSetsAssists() {
        jkurri.setAssists(200);
        assertEquals(jkurri.getAssists(), 200);
    }

    @Test
    public void PlayerReturnsGoals() {
        assertEquals(jkurri.getGoals(), 37);
    }

    @Test
    public void PlayerSetsGoals() {
        jkurri.setGoals(200);
        assertEquals(jkurri.getGoals(), 200);
    }

    @Test
    public void PlayerSetsName() {
        String jari = "Jari Kurri";
        jkurri.setName(jari);
        assertEquals(jkurri.getName(), jari);
    }

    @Test
    public void PlayerSetsTeam() {
        jkurri.setTeam("NYR");
        assertEquals(jkurri.getTeam(), "NYR");
    }

    @Test
    public void ToStringWorksProperly() {
        String jari = String.format("%-20s", "Kurri") + " " + "EDM" + " " + String.format("%2d", 37) + " + "
                + String.format("%2d", 53) + " = 90";
        assertEquals(jkurri.toString(), jari);

    }

}
