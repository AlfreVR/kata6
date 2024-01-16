package software.ulpgc.kata6;

public class Board {

    private final String[] state;

    private String winner;

    public Board(String state) {
        this(state.split("\n"));
    }

    public Board(String[] state) {
        this.state = state;
    }

    public String winner() {
        return winner = calculateWinner();
    }

    private String calculateWinner() {
        setWinner("");
        String wins =getWinner();
        wins = checkColumns();
        wins = checkRows(wins);
        wins = checkDiagonals(wins);
        wins = draw(wins);
        return wins;
    }

    private String draw(String wins) {
        int nonPlayedSpaces = 0;
        for (String s : state) {
            for (int j = 0; j < state.length; j++) {
                if (s.charAt(j) == '-') nonPlayedSpaces++;
            }
        }
        if(nonPlayedSpaces == 0){
            if(getWinner().isEmpty()) setWinner("draw");
        }
        return this.winner;
    }

    private String checkDiagonals(String wins) {
        if(!wins.isEmpty()) return wins;
        char first_diagonal_check = state[0].charAt(0);
        char second_diagonal_check = state[0].charAt(2);
        if(first_diagonal_check != '-' && state[1].charAt(1) == first_diagonal_check && state[2].charAt(2) == first_diagonal_check){
            setWinner(String.valueOf(first_diagonal_check));
        }else if(second_diagonal_check != '-' && state[1].charAt(1) == second_diagonal_check && state[2].charAt(0) == second_diagonal_check){
            setWinner(String.valueOf(second_diagonal_check));
        }
        return this.winner;
    }

    private String checkRows(String wins) {
        if(!wins.isEmpty()) return wins;
        for (String s : state) {
            char first_column_check = s.charAt(0);
            if (first_column_check != '-') {
                if (s.charAt(1) == first_column_check && s.charAt(2) == first_column_check) {
                    setWinner(String.valueOf(first_column_check));
                    break;
                }
            }

        }
        return this.winner;
    }

    private String checkColumns() {
        for (int i = 0; i < state.length; i++) {
            char first_row_check = state[0].charAt(i);
            if(first_row_check != '-') {
                if(state[1].charAt(i) ==first_row_check && state[2].charAt(i) == first_row_check){
                    setWinner(String.valueOf(first_row_check));
                    break;
                }
            }

        }
        return this.winner;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }


}
