/* 
Пользователь вводит одну строку, в которой должно быть записано простое арифметическое выражение вида "a <операция> b", где a и b - какие-то действительные числа, а операция - один из символов "+", "-", "*", "/". Ваша задача - выполнить вычисление, если это возможно. Гарантируется, что в введённой строке ровно 2 пробела (значение пробел значение пробел значение) В результате работы могут произойти различные ошибки. Их нужно обработать следующим образом:
Если одно из чисел не является числом, то вывести на экран "Error! Not number"
Если вместо знака операции было введено любое другое значение, то выведите "Operation Error!"
Если произошла попытка деления на ноль, то выведите на экран "Error! Division by zero"
Обрабатывать исключения необходимо в указанном выше порядке.
 Продолжите работу над проектом. Добавьте возможность считывания одной строчки из файла input.txt. */

import java.util.*;
import java.io.*;

public class MyProgramm {
    public static void main (String[] args) throws Exception {
        try  {
            FileReader r = new FileReader("input.txt");
            Scanner sc = new Scanner(r);
            while(sc.hasNextLine()){
                System.out.println(calculator(sc.nextLine()));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());}}

    public static double calculator (String str) throws Exception{
        String [] s = str.split(" ");
        double a;
        double b;
        try {
            a = Double.parseDouble(s[0]);
            b = Double.parseDouble(s[2]);}
        catch (NumberFormatException e) {  //NumberFormatException – неконтролируемое исключение – когда он не может преобразовать строку в тип числа
            throw new Exception("Error! Not number");}
            if (!s[1].equals("+") && !s[1].equals("-") && !s[1].equals("*") && !s[1].equals("/")) {
            throw new Exception("Operation Error!");}
        if (s[1].equals("+")) {
            return a + b;}
        else if (s[1].equals("-")) {
            return a - b;}
        else if (s[1].equals("*")) {
            return a * b; }
        else if (s[1].equals("/")) {
            if (b == 0) {
                throw new Exception("Error! Division by zero");}
            return a / b;}
        else return 0;}}







