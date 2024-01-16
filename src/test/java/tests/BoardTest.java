package tests;

import org.junit.Test;
import software.ulpgc.kata6.Board;

import static org.assertj.core.api.Assertions.assertThat;
import static tests.BoardTest.Cases.*;

public class BoardTest {
    @Test
    public void should_return_no_winners_given_empty_board(){
        Board board = new Board(empty_board_3x3);
        assertThat(board.winner()).isEqualTo("");
    }

    @Test
    public void should_return_x_wins_given_3x3_board_with_3_x_column(){
        Board board = new Board(column_3_x_board_3x3);
        assertThat(board.winner()).isEqualTo("x");
    }

    @Test
    public void should_return_o_wins_given_3x3_board_with_3_o_row(){
        Board board = new Board(row_3_o_board_3x3);
        assertThat(board.winner()).isEqualTo("o");
    }

    @Test
    public void should_return_o_wins_given_3x3_board_with_3_o_diagonal(){
        Board board = new Board(diagonal_3_o_board_3x3);
        assertThat(board.winner()).isEqualTo("o");
    }

    @Test
    public void should_return_draw_given_3x3_board_with_draw(){
        Board board = new Board(draw_board_3x3);
        assertThat(board.winner()).isEqualTo("draw");
    }


    public static class Cases {
        public static String empty_board_3x3 = """
                ---
                ---
                ---
                """.trim();
    public static String column_3_x_board_3x3 = """
                x--
                x--
                x--
                """.trim();
    public static String row_3_o_board_3x3 = """
                x--
                ooo
                ---
                """.trim();
    public static String diagonal_3_o_board_3x3 = """
                o--
                xox
                --o
                """.trim();
    public static String draw_board_3x3 = """
                oxo
                xox
                xox
                """.trim();
    }

}

