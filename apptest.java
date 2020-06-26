package webdev;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class apptest{

    @Test
    void numberTest(){
        char[] blackTest = {'2','H','3','D','5','S','9','C','K','D'};
        char[] whiteTest = {'2','C','3','H','4','S','8','C','A','H'};
        poke Poke = new poke();
        int[] shouleBlackInit = {2, 3, 5, 9, 13};
        int[] blackInit = Poke.pokeInit(blackTest);
        int[] shouleWhiteInit = {2, 3, 4, 8, 14};
        int[] whiteInit = Poke.pokeInit(whiteTest);
        assertEquals(shouleBlackInit, blackInit);
        assertEquals(shouleWhiteInit, whiteInit);
    }

    @Test
    void compareTest(){
        char[] blackTest = {'2','H','4','S','4','C','2','D','4','H'};
        char[] whiteTest = {'2','S','8','S','A','S','Q','S','3','S'};
        poke Poke = new poke();
        assertEquals("White wins", Poke.pokeCmp(blackTest, whiteTest));
    }

    @Test
    void typeTest(){
        char[] type = {'2','C','3','H','4','S','5','C','6','H'};
        poke Poke = new poke();
        assertEquals(3, Poke.pokeType(type));
    }
}