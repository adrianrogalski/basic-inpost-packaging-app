package app;

import data.Item;
import exceptions.ArgumentsNumberError;
import exceptions.DimensionValueExceededError;
import exceptions.NegativeNumbersError;
import exceptions.WeightExceededError;
import logic.Box;

import java.util.Scanner;

public class BoxApp {
    public static void main(String[] args) {
        help();
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        try {
            Item item = Item.of(userInput);
            System.out.println(Box.putItem(item));
        }
        catch (DimensionValueExceededError e) {
            System.err.println("Zbyt duży wymiar przedmiotu");
            help();
        }
        catch (WeightExceededError e) {
            System.err.println("Zbyt duża waga przedmiotu");
            help();
        }
        catch (NumberFormatException e) {
            System.err.println("Wpisz liczbę!");
            help();
        }
        catch (ArgumentsNumberError e) {
            System.err.println("Wymagane jest użycie 5 argumentów");
            help();
        }
        catch (NegativeNumbersError e) {
            System.err.println("Liczby muszą być dodatnie!");
            help();
        }

    }

    public static void help() {
        System.out.println("Format: <wymiarA> <wymiarB> <wymiarC> <waga> <cena>");
        System.out.println("Dostępne paczki: ");
        System.out.println("A - 80x380x640,waga do 25 kg, 12,99 PLN\n" +
                "B - 190x380x640 waga 25 kg, 13,99 PLN\n" +
                "C - 410x380x640 waga 25 kg, 15,49 PLN");
    }
}
