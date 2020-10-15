package com.tdd.bowlinggame;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BowlingGameApplicationTests {


    @Test
    public void testGutterGame() {
        BowlingGame game = new BowlingGame();

        for (int aThrow = 0; aThrow < 20; aThrow++) {
            game.roll(0);
        }
        assertEquals(0, game.getScore());
    }

    @Test
    public void lowScoringGame() {
        BowlingGame game = new BowlingGame();

        for (int aThrow = 0; aThrow < 20; aThrow++) {
            game.roll(1);
        }
        assertEquals(20, game.getScore());
    }

    @Test
    public void OneSpareGame() {
        BowlingGame game = new BowlingGame();

        game.roll(1);
        game.roll(9);
        for (int aThrow = 0; aThrow < 18; aThrow++) {
            game.roll(1);
        }
        assertEquals(29, game.getScore());
    }

    @Test
    public void multipleSpareGame() {
        BowlingGame game = new BowlingGame();

        game.roll(1);
        game.roll(9);
        game.roll(1);
        game.roll(9);
        game.roll(1);
        game.roll(9);
        for (int aThrow = 0; aThrow < 14; aThrow++) {
            game.roll(1);
        }
        assertEquals(47, game.getScore());
    }

    @Test
    public void oneStrikeGame() {
        BowlingGame game = new BowlingGame();

        game.roll(10);
        for (int aThrow = 0; aThrow < 18; aThrow++) {
            game.roll(1);
        }
        assertEquals(30, game.getScore());
    }

    @Test
    public void fiveStrikeGame() {
        BowlingGame game = new BowlingGame();

        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        for (int aThrow = 0; aThrow < 10; aThrow++) {
            game.roll(1);
        }
        assertEquals(133, game.getScore());
    }

    @Test
    public void testPerfectGame() {
        BowlingGame game = new BowlingGame();

        for (int aThrow = 0; aThrow < 11; aThrow++) {
            game.roll(10);
        }
        assertEquals(300, game.getScore());
    }


    @Test
    public void testLastFrameSpareGame() {
        BowlingGame game = new BowlingGame();

        for (int aThrow = 0; aThrow < 18; aThrow++) {
            game.roll(1);
        }
        game.roll(1);
        game.roll(9);
        game.roll(1);
        assertEquals(29, game.getScore());
    }

    @Test
    public void testLastFrameStrikeGame() {
        BowlingGame game = new BowlingGame();

        for (int aThrow = 0; aThrow < 18; aThrow++) {
            game.roll(1);
        }
        game.roll(10);
        game.roll(10);
        game.roll(10);
        assertEquals(48, game.getScore());
    }


}
