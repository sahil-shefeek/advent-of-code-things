// Day 1 - Answer : 55413

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.*;

public class part2 {
    public static void main(String[] args) {
        int index = 0, firstNum = 0, lastNum = 0, sum = 0;
        int[] results = new int[10000];
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("input.txt"));
            String line;
            ArrayList<Integer> digits = new ArrayList<Integer>(100);
            while ((line = reader.readLine()) != null) {
                digits.clear();
                int digit;
                for (int i = 0; i < line.length(); i++) {
                    String substring = line.substring(i);
                    Pattern pattern = Pattern.compile("^(one|two|three|four|five|six|seven|eight|nine|\\d)");
                    Matcher matcher = pattern.matcher(substring);
                    while (matcher.find()) {

                        String strdig = matcher.group();
                        System.out.println(strdig);
                        digit = switch (strdig) {
                            case "one" -> 1;
                            case "two" -> 2;
                            case "three" -> 3;
                            case "four" -> 4;
                            case "five" -> 5;
                            case "six" -> 6;
                            case "seven" -> 7;
                            case "eight" -> 8;
                            case "nine" -> 9;
                            default -> Integer.parseInt(strdig);
                        };
                        digits.add(digit);
                    }
                    if (!digits.isEmpty()) {
                        firstNum = digits.getFirst(); // First digit
                        lastNum = digits.getLast();
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
