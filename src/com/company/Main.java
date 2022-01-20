package com.company;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        LinkedList<String> first = new LinkedList<> (Arrays.asList ("abc", "xyz"));
        LinkedList<String> second = new LinkedList<> (Arrays.asList("cde", "rar"));
        System.out.println(merge(first, second));

        // Homework 3
        LinkedList<String> words = new LinkedList<>();
        try (Scanner sc = new Scanner(System.in)){
            while (sc.hasNextLine()) {
                String word = sc.nextLine();
                if (word.equals("!"))
                    break;
                words.add(word);
            }
            sc.reset();
            while (sc.hasNextLine()){
                String word = sc.nextLine();
                if (word.equals("!"))
                    break;
                else {
                    for (int i = 0; i < words.size(); i++) {
                        if (word.equals(words.get(i))) {
                            System.out.println("hit");
                            break;
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("got exception " + e);
        }
    }
    public static LinkedList<String> merge (LinkedList<String> l1,
                                            LinkedList<String> l2) {
        LinkedList<String> combination = new LinkedList<>();
        while (!l1.isEmpty() || !l2.isEmpty()) {
            LinkedList<String> choice = new LinkedList<>();
            if (l1.isEmpty())
                choice = l2;
            else if (l2.isEmpty())
                choice = l1;
            else if (l1.peekFirst().compareTo(l2.peekFirst()) <= 0)
                choice = l1;
            else
                choice = l2;
            combination.add(choice.removeFirst());
        }
        return combination;
    }

}
// The handouts