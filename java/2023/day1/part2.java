// Day 1 - Answer : 55712

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class part2 {
    public static void main(String[] args) {
        int index = 0, firstNum = 0, lastNum = 0, sum = 0;
        int[] results = new int[10000];
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("/Users/sahil/Developer/ADC/java/day1/src/input.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                char[] chars = line.toCharArray();
                char ch;
                for (int i = 0; i < line.length(); i++) {
                    ch = chars[i];
                    if (Character.isDigit(ch)) {
                        firstNum = Character.getNumericValue(ch);
                        break;
                    } else {
                        // String subString = line.substring(i, i + 3);
                        // if (subString.matches("one|two|six"))
                        // ;
                        if (ch == 'o') {
                            if (chars[i + 1] == 'n') {
                                if (chars[i + 2] == 'e') {
                                    firstNum = 1;
                                    break;
                                }
                            }
                        } else if (ch == 't') {
                            if (chars[i + 1] == 'w') {
                                if (chars[i + 2] == 'o') {
                                    firstNum = 2;
                                    break;
                                }
                            } else if (chars[i + 1] == 'h') {
                                if (line.substring(i, i + 5).equals("three")) {
                                    firstNum = 3;
                                    break;
                                }
                            }
                        }
                    }
                }

                for (int i = line.length() - 1; i >= 0; i--) {
                    ch = chars[i];
                    if (Character.isDigit(ch)) {
                        lastNum = Character.getNumericValue(ch);
                        break;
                    }
                }
                results[index++] = firstNum * 10 + lastNum;
            }
            for (int result : results) {
                sum += result;
            }
            System.out.println("The calibration value is:" + sum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
