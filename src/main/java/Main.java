import calculator.CalculatorService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();
        Scanner commandScanner = new Scanner(System.in);
        Scanner inputScanner = new Scanner(System.in);
        Boolean isArabic = false;

        while (true) {
            printMenu();
            int command = commandScanner.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Введите операцию, используя арабские цифры");
                    String input = inputScanner.nextLine();
                    System.out.println(calculatorService.calculate(input, !isArabic));
                    break;
                case 2:
                    System.out.println("Введите операцию, используя римские цифры");
                    String input2 = inputScanner.nextLine();
                    System.out.println(calculatorService.calculate(input2, isArabic));
            }
        }
    }

    public static void printMenu() {
        System.out.println("Меню:");
        System.out.println("1 - посчитать арабские цифры");
        System.out.println("2 - посчитать римские цифры");
    }
}