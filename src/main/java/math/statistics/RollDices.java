package math.statistics;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;

public class RollDices {
    // The goal is to implement a different kind od dies, which include:
    // 4-sided, 6-sided, 8-sided, 12-sided and 20-sided.
    // I need also methods for n times of rollin.
    // The hardest part I think will be implementing statistic rules to a random methods.

    // LETS START::


    //4
    int dice[] = new int[3];

    public static void main(String[] args) {
        //PrintStream test = System.out.append("ifj", 1,3);
        //test.println("Mateusz");


        PrintStream test2 = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        });
        test2.println("test");

    }

}
