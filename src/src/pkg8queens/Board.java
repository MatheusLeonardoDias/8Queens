package pkg8queens;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    boolean[][] table;

    Board(ArrayList<Tuple> t, int size) {
        table = new boolean[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = false;
            }
        }
        for (int i = 0; i < t.size(); i++) {
            table[t.get(i).first][t.get(i).second] = true;
        }
    }

    public void print() {
        System.out.println("\n************************");
        for (int i = 0; i < table.length; ++i) {
            for (int j = 0; j < table.length; ++j) {
                System.out.print("|" + (table[i][j] ? "X" : "0") + "|");
            }
            System.out.println();
        }
        System.out.println("\n************************\n");
    }

    public boolean isValidSetup() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j]) {

                    /* Coluna */
                    for (int k = i+1; k < table.length; k++) {
                        if (table[k][j] ) {
                            return false;
                        }
                    }

                    /* Linha */
                    for (int k = j+1; k < table.length; k++) {
                        if (table[i][k] ) {
                            return false;
                        }
                    }
                    
                    for (int k = 1; i+k < table.length && j+k < table.length; k++) {
                        if( table[i+k][j+k] ) return false;
                    }
                    for (int k = 1; i+k < table.length && j-k >= 0; k++) {
                        if( table[i+k][j-k] ) return false;
                    }

                }
            }

        }

        return true;
    }
}
