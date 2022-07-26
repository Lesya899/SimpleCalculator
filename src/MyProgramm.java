/*
1) Пользователь вводит одну строку, в которой должно быть записано простое арифметическое выражение вида "a <операция> b", где a и b - какие-то действительные числа, а операция - один из символов "+", "-", "*", "/". Ваша задача - выполнить вычисление, если это возможно. Гарантируется, что в введённой строке ровно 2 пробела (значение пробел значение пробел значение) В результате работы могут произойти различные ошибки. Их нужно обработать следующим образом:
Если одно из чисел не является числом, то вывести на экран "Error! Not number"
Если вместо знака операции было введено любое другое значение, то выведите "Operation Error!"
Если произошла попытка деления на ноль, то выведите на экран "Error! Division by zero"
Обрабатывать исключения необходимо в указанном выше порядке.
 2)  Добавьте возможность считывания одной строчки из файла input.txt.
  3) Теперь, помимо считывания строки из файла, добавьте возможность записи ответа в файл output.txt.
  4) Теперь в файле input.txt лежит не одна, а неизвестное количество строк. Ваша задача - сформировать файл output.txt, в котором для каждой строчки будет лежать ответ вида: "<исходная строка> = <ответ к этой строке>".*/

import java.util.*;
import java.io.*;

public class MyProgramm {
    public static void main (String[] args) throws Exception {
        FileReader r = new FileReader("input.txt");
        FileWriter wr = new FileWriter ("output.txt");
        Scanner sc = new Scanner(r);
        String a = ""; //initialize the variable for the first number
        String sim = ""; //initialize the variable for the symbol
        String b = "";  //initialize the variable for the second number
            while(sc.hasNextLine()){
                try  {
                    a = sc.next();
                    sim = sc.next();
                    b = sc.nextLine();
                    String res = Double.toString(calculator(a, sim, b));  //use calculator
                wr.write(a + " " + sim + " " + b + " = " + res + "\n"); //write the result to a file according to the template
        } catch (Exception ex) {
                    wr.write(a + " " + sim + " " + b + " = " + ex.getMessage() + "\n");;}} //in case of an exception, we write a message about it to the file according to the template
            r.close();
            wr.close();}

    public static double calculator (String a, String sim, String b ) throws Exception{
        double n;
        double m;
        try {
            n = Double.parseDouble(a);
            m = Double.parseDouble(b);}
        catch (NumberFormatException e) {  //NumberFormatException – unchecked exception when it is not possible to convert string to numeric type
            throw new Exception("Error! Not number");}
            if (!sim.equals("+") && !sim.equals("-") && !sim.equals("*") && !sim.equals("/")) {
            throw new Exception("Operation Error!");}
        if (sim.equals("+")) {
            return n + m;}
        else if (sim.equals("-")) {
            return n - m;}
        else if (sim.equals("*")) {
            return n * m; }
        else if (sim.equals("/")) {
            if (m == 0) {
                throw new Exception("Error! Division by zero");}
            return n / m;}
        else return 0;}}







