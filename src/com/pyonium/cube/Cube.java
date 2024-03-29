package com.pyonium.cube;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Cube {

    int[] cubletsPosition = new int[8];
    int[] cubletsRotation = new int[8];
    String moves[] = {"U", "F", "R", "U'", "F'", "R'"};

    int moveCount = 0;
    String moveList = "";

    public Cube(String stringInput){
        char[] input = stringInput.toCharArray();
        char[][] cublets = new char[8][3];
        cublets[0] = new char[]{input[0],  input[16], input[14]};
        cublets[1] = new char[]{input[1],  input[15], input[21]};
        cublets[2] = new char[]{input[2],  input[4],  input[17]};
        cublets[3] = new char[]{input[3],  input[20], input[5] };
        cublets[4] = new char[]{input[10], input[12], input[18]};
        cublets[5] = new char[]{input[11], input[23], input[13]};
        cublets[6] = new char[]{input[8],  input[19], input[6] };
        cublets[7] = new char[]{input[9],  input[7],  input[22]};

        /*
         * On a 2d projection, The white / yellow faces need to be on top. If they're not, they are either rotated once or twice.
         * These are all the possibilities of the cubes.
         * Courtesy of the excellent KitN on Github.
         */
        char[][] cubletColors = new char[][]{
                {'y', 'r', 'b'}, {'r', 'b', 'y'}, {'b', 'y', 'r'},
                {'y', 'b', 'o'}, {'b', 'o', 'y'}, {'o', 'y', 'b'},
                {'y', 'g', 'r'}, {'g', 'r', 'y'}, {'r', 'y', 'g'},
                {'y', 'o', 'g'}, {'o', 'g', 'y'}, {'g', 'y', 'o'},
                {'w', 'b', 'r'}, {'b', 'r', 'w'}, {'r', 'w', 'b'},
                {'w', 'o', 'b'}, {'o', 'b', 'w'}, {'b', 'w', 'o'},
                {'w', 'r', 'g'}, {'r', 'g', 'w'}, {'g', 'w', 'r'},
                {'w', 'g', 'o'}, {'g', 'o', 'w'}, {'o', 'w', 'g'}
        };

        /*
         * Here we map our current input to a cube. If we find a valid cublet, we map it in our position / rotation mapping.
         */
        for(int i = 0; i < 8; i++){
            int index = 0;
            while (true) {
                if (Arrays.equals(cublets[i], cubletColors[index])) {
                    break;
                }
                index++;
                if(index > 23){
                    break;
                }
            }
            cubletsPosition[i] = index / 3;
            cubletsRotation[i] = index % 3;
        }
    }

    /*
     * If the cube is rotated and doesn't move on the Y axis, we increment by two on clockwise moves,
     * and by one on counterclockwise moves. Since we %3, to and from cancel each other out.
     *
     *      ---------
     *    / 0    1 / |
     *   /_2____3_/  |
     *   |        |  |
     *   | 4    5 | /
     *   |6____7__|/
     */
    public void rotate(String[] moves){
        for (String face : moves){
            switch (face) {
                case "F":
                    cubletsPosition = new int[]{cubletsPosition[0], cubletsPosition[1], cubletsPosition[6], cubletsPosition[2], cubletsPosition[4], cubletsPosition[5], cubletsPosition[7], cubletsPosition[3]};
                    cubletsRotation = new int[]{cubletsRotation[0], cubletsRotation[1], (cubletsRotation[6]+1) % 3, (cubletsRotation[2]+2) % 3, cubletsRotation[4], cubletsRotation[5], (cubletsRotation[7]+2) % 3, (cubletsRotation[3]+1) % 3};
                    break;
                case "R":
                    cubletsPosition = new int[]{cubletsPosition[0], cubletsPosition[3], cubletsPosition[2], cubletsPosition[7], cubletsPosition[4], cubletsPosition[1], cubletsPosition[6], cubletsPosition[5]};
                    cubletsRotation = new int[]{cubletsRotation[0], (cubletsRotation[3]+2) % 3, cubletsRotation[2], (cubletsRotation[7]+1) % 3, cubletsRotation[4], (cubletsRotation[1]+1) % 3, cubletsRotation[6], (cubletsRotation[5]+2) % 3};
                    break;
                case "U":
                    cubletsPosition = new int[]{cubletsPosition[2], cubletsPosition[0], cubletsPosition[3], cubletsPosition[1], cubletsPosition[4], cubletsPosition[5], cubletsPosition[6], cubletsPosition[7]};
                    cubletsRotation = new int[]{cubletsRotation[2], cubletsRotation[0], cubletsRotation[3], cubletsRotation[1], cubletsRotation[4], cubletsRotation[5], cubletsRotation[6], cubletsRotation[7]};
                    break;
                case "F'":
                    cubletsPosition = new int[]{cubletsPosition[0], cubletsPosition[1], cubletsPosition[3], cubletsPosition[7], cubletsPosition[4], cubletsPosition[5], cubletsPosition[2], cubletsPosition[6]};
                    cubletsRotation = new int[]{cubletsRotation[0], cubletsRotation[1], (cubletsRotation[3]+1) % 3, (cubletsRotation[7]+2) % 3, cubletsRotation[4], cubletsRotation[5], (cubletsRotation[2]+2) % 3, (cubletsRotation[6]+1) % 3};
                    break;
                case "R'":
                    cubletsPosition = new int[]{cubletsPosition[0], cubletsPosition[5], cubletsPosition[2], cubletsPosition[1], cubletsPosition[4], cubletsPosition[7], cubletsPosition[6], cubletsPosition[3]};
                    cubletsRotation = new int[]{cubletsRotation[0], (cubletsRotation[5]+2) % 3, cubletsRotation[2], (cubletsRotation[1]+1) % 3, cubletsRotation[4], (cubletsRotation[7]+1) % 3, cubletsRotation[6], (cubletsRotation[3]+2) % 3};
                    break;
                case "U'":
                    cubletsPosition = new int[]{cubletsPosition[1], cubletsPosition[3], cubletsPosition[0], cubletsPosition[2], cubletsPosition[4], cubletsPosition[5], cubletsPosition[6], cubletsPosition[7]};
                    cubletsRotation = new int[]{cubletsRotation[1], cubletsRotation[3], cubletsRotation[0], cubletsRotation[2], cubletsRotation[4], cubletsRotation[5], cubletsRotation[6], cubletsRotation[7]};
                    break;
                default:
                    break;
            }
        }
    }

    /*
     * Let's try to solve the cube 14 turns deep. It returns an array of moves, so we concatenate it to a string,
     * and print the result. Solved!
     * 14 turns isn't actually computationally possible with this implementation, but it works.
     *
     * Two test cases: y y r w g o w o o y w b b y r r g w r b g b g o
     * and another: o o g g w w g o r b w r b y y b g r r y o w y b
     */
    public void solve(){
        String[] turns = trySolve(14);
        for(int i = 0; i < turns.length; ++i){
            moveList += turns[i];
            moveList += " ";
            moveCount++;
        }

        System.out.println(moveList);
        System.out.println("Amount of moves: " + moveCount);

        JOptionPane.showMessageDialog(new Frame(), moveList + " solved in " + moveCount + " moves");
    }

    /*
     * Where the magic happens. I create n base 6 digits, where n is the solve depth, and map each of those to
     * their own move. Then I iterate through all the moves. If everything is correct (cube 0 is at pos 0 etc.)
     * and all cubes aren't rotated (have rotation 0), they're solved.
     */
    public String[] trySolve(int depth){
        String[] answer = {"None found."};
        int[] startPos = new int[8];
        int[] startRot = new int[8];
        startPos = cubletsPosition;
        startRot = cubletsRotation;
        String baseSixDigits = "";
        for(int i = 0; i < depth; i++){
            baseSixDigits += "5";
        }

        for(long i = 0; i <= Long.parseLong(baseSixDigits, 6); i++){
            cubletsPosition = startPos;
            cubletsRotation = startRot;
            String moveString = Long.toString(i, 6);
            String[] usedMoves = new String[moveString.length()];
            for(int j = 0; j < moveString.length(); j++){
                String move = moves[Integer.parseInt(moveString.substring(j, j+1))];
                usedMoves[j] = move;
            }
            rotate(usedMoves);
            int correct = 0;
            for(int j = 0; j < 8; j++){
                if(cubletsPosition[j] == j && cubletsRotation[j] == 0){
                    correct++;
                }
            }
            if(i % 100000 == 0){
                InputWindow.w.setTitle(i + " / " + Long.parseLong(baseSixDigits, 6));
            }
            if(correct == 8){
                answer = usedMoves;
                break;
            }
        }
        cubletsPosition = startPos;
        cubletsRotation = startRot;

        return answer;
    }

    public static Cube makeCube(){
        String cubeString = "";
        for(int i = 0; i < 24; i++){
            switch(InputWindow.buttons.get(i).getColor()){
                case 0:
                    cubeString += "y";
                    break;
                case 1:
                    cubeString += "g";
                    break;
                case 2:
                    cubeString += "w";
                    break;
                case 3:
                    cubeString += "b";
                    break;
                case 4:
                    cubeString += "r";
                    break;
                case 5:
                    cubeString += "o";
                    break;
            }
        }
        return new Cube(cubeString);
    }

}
