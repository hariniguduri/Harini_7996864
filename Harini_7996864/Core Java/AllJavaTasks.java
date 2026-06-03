import java.io.*;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class AllJavaTasks {

    // Task 1
    static void task1() {

        System.out.println("Hello, World!");
    }

    // Task 2
    static void task2() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.print("Enter operator (+,-,*,/): ");
        char op = sc.next().charAt(0);

        switch (op) {

            case '+' ->
                    System.out.println("Result = " + (num1 + num2));

            case '-' ->
                    System.out.println("Result = " + (num1 - num2));

            case '*' ->
                    System.out.println("Result = " + (num1 * num2));

            case '/' -> {

                if (num2 != 0)
                    System.out.println("Result = " + (num1 / num2));
                else
                    System.out.println("Cannot divide by zero");
            }

            default ->
                    System.out.println("Invalid Operator");
        }
    }

    // Task 3
    static void task3() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = sc.nextInt();

        if (num % 2 == 0)
            System.out.println("Even");
        else
            System.out.println("Odd");
    }

    // Task 4
    static void task4() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        if ((year % 4 == 0 && year % 100 != 0)
                || (year % 400 == 0))

            System.out.println("Leap Year");

        else
            System.out.println("Not Leap Year");
    }

    // Task 5
    static void task5() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = sc.nextInt();

        for (int i = 1; i <= 10; i++) {

            System.out.println(
                    num + " x " + i + " = " + (num * i)
            );
        }
    }

    // Task 6
    static void task6() {

        int a = 10;
        float b = 5.5f;
        double c = 99.99;
        char d = 'H';
        boolean e = true;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }

    // Task 7
    static void task7() {

        double value = 55.78;

        int num = (int) value;

        System.out.println("Double to int = " + num);

        int number = 25;

        double result = (double) number;

        System.out.println("Int to double = " + result);
    }

    // Task 8
    static void task8() {

        int result = 10 + 5 * 2;

        System.out.println("Result = " + result);
    }

    // Task 9
    static void task9() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter marks: ");
        int marks = sc.nextInt();

        if (marks >= 90)
            System.out.println("Grade A");

        else if (marks >= 80)
            System.out.println("Grade B");

        else if (marks >= 70)
            System.out.println("Grade C");

        else if (marks >= 60)
            System.out.println("Grade D");

        else
            System.out.println("Grade F");
    }

    // Task 10
    static void task10() {

        Random random = new Random();

        int target = random.nextInt(100) + 1;

        Scanner sc = new Scanner(System.in);

        int guess;

        do {

            System.out.print("Guess the number: ");
            guess = sc.nextInt();

            if (guess > target)
                System.out.println("Too High");

            else if (guess < target)
                System.out.println("Too Low");

            else
                System.out.println("Correct Guess");

        } while (guess != target);
    }

    // Task 11
    static void task11() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = sc.nextInt();

        long factorial = 1;

        for (int i = 1; i <= num; i++) {

            factorial *= i;
        }

        System.out.println("Factorial = " + factorial);
    }

    // Task 12
    int add(int a, int b) {

        return a + b;
    }

    double add(double a, double b) {

        return a + b;
    }

    int add(int a, int b, int c) {

        return a + b + c;
    }

    // Task 13
    static int fibonacci(int n) {

        if (n <= 1)
            return n;

        return fibonacci(n - 1)
                + fibonacci(n - 2);
    }

    // Task 14
    static void task14() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        int sum = 0;

        for (int i = 0; i < size; i++) {

            System.out.print("Enter element: ");

            arr[i] = sc.nextInt();

            sum += arr[i];
        }

        double average = (double) sum / size;

        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
    }

    // Task 15
    static void task15() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");

        String str = sc.nextLine();

        String reverse =
                new StringBuilder(str)
                        .reverse()
                        .toString();

        System.out.println(
                "Reversed String = " + reverse
        );
    }

    // Task 16
    static void task16() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");

        String str = sc.nextLine();

        str = str.replaceAll(
                "[^a-zA-Z0-9]",
                ""
        ).toLowerCase();

        String reverse =
                new StringBuilder(str)
                        .reverse()
                        .toString();

        if (str.equals(reverse))
            System.out.println("Palindrome");

        else
            System.out.println("Not Palindrome");
    }

    // Task 17
    static class Car {

        String make;
        String model;
        int year;

        void displayDetails() {

            System.out.println(
                    make + " "
                            + model + " "
                            + year
            );
        }
    }

    // Task 18
    static class Animal {

        void makeSound() {

            System.out.println("Animal Sound");
        }
    }

    static class Dog extends Animal {

        void makeSound() {

            System.out.println("Bark");
        }
    }

    // Task 19
    interface Playable {

        void play();
    }

    static class Guitar implements Playable {

        public void play() {

            System.out.println("Playing Guitar");
        }
    }

    static class Piano implements Playable {

        public void play() {

            System.out.println("Playing Piano");
        }
    }

    // Task 20
    static void task20() {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            System.out.println("Result = " + (a / b));

        } catch (ArithmeticException e) {

            System.out.println(
                    "Cannot divide by zero"
            );
        }
    }

    // Task 21
    static class InvalidAgeException
            extends Exception {

        InvalidAgeException(String msg) {

            super(msg);
        }
    }

    static void checkAge(int age)
            throws InvalidAgeException {

        if (age < 18)
            throw new InvalidAgeException(
                    "Age must be 18 or above"
            );

        System.out.println(
                "Eligible to vote"
        );
    }

    // Task 22
    static void task22() throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");

        String text = sc.nextLine();

        FileWriter writer =
                new FileWriter("output.txt");

        writer.write(text);

        writer.close();

        System.out.println(
                "Data written to file"
        );
    }

    // Task 23
    static void task23() throws Exception {

        File file = new File("output.txt");

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {

            System.out.println(sc.nextLine());
        }

        sc.close();
    }

    // Task 24
    static void task24() {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> names =
                new ArrayList<>();

        System.out.print(
                "How many names: "
        );

        int n = sc.nextInt();

        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter name: ");

            names.add(sc.nextLine());
        }

        System.out.println(names);
    }

    // Task 25
    static void task25() {

        Scanner sc = new Scanner(System.in);

        HashMap<Integer, String> map =
                new HashMap<>();

        System.out.print(
                "Enter number of students: "
        );

        int n = sc.nextInt();

        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Name: ");

            String name = sc.nextLine();

            map.put(id, name);
        }

        System.out.print(
                "Enter ID to search: "
        );

        int searchId = sc.nextInt();

        System.out.println(
                "Student Name: "
                        + map.get(searchId)
        );
    }

    // Task 26
    static class MyThread extends Thread {

        public void run() {

            for (int i = 1; i <= 5; i++) {

                System.out.println(
                        Thread.currentThread()
                                .getName()
                );
            }
        }
    }

    // Task 27
    static void task27() {

        List<String> fruits =
                new ArrayList<>();

        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Orange");

        Collections.sort(
                fruits,
                (a, b) -> a.compareTo(b)
        );

        System.out.println(fruits);
    }

    // Task 28
    static void task28() {

        List<Integer> numbers =
                Arrays.asList(1,2,3,4,5,6);

        List<Integer> evenNumbers =
                numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .collect(Collectors.toList());

        System.out.println(evenNumbers);
    }

    // Task 29
    record Person(String name, int age) {}

    static void task29() {

        List<Person> list = List.of(

                new Person("A",20),
                new Person("B",30),
                new Person("C",40)
        );

        List<Person> filtered =
                list.stream()
                        .filter(p -> p.age() > 25)
                        .toList();

        System.out.println(filtered);
    }

    // Task 30
    static void task30(Object obj) {

        switch (obj) {

            case Integer i ->
                    System.out.println(
                            "Integer " + i
                    );

            case String s ->
                    System.out.println(
                            "String " + s
                    );

            case Double d ->
                    System.out.println(
                            "Double " + d
                    );

            default ->
                    System.out.println("Unknown");
        }
    }

    /*// Task 31
    static Connection getConnection()
            throws Exception {

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb",
                "root",
                "password"
        );
    }

    static void task31() throws Exception {

        Connection con = getConnection();

        Statement st =
                con.createStatement();

        ResultSet rs =
                st.executeQuery(
                        "SELECT * FROM students"
                );

        while (rs.next()) {

            System.out.println(
                    rs.getInt(1)
                            + " "
                            + rs.getString(2)
            );
        }

        con.close();
    }
*/
    /* 
    // Task 32
    static void task32() throws Exception {
 
        Connection con = getConnection();

        PreparedStatement ps =
                con.prepareStatement(
                        "INSERT INTO students VALUES (?,?)"
                );

        ps.setInt(1, 1);

        ps.setString(2, "John");

        ps.executeUpdate();

        System.out.println(
                "Record Inserted"
        );

        con.close();
    }
*/
   
   /*
    // Task 33
    static void task33() throws Exception {

        Connection con = getConnection();

        con.setAutoCommit(false);

        try {

            Statement st =
                    con.createStatement();

            st.executeUpdate(
                    "UPDATE students SET name='A' WHERE id=1"
            );

            con.commit();

            System.out.println(
                    "Transaction Successful"
            );

        } catch (Exception e) {

            con.rollback();

            System.out.println(
                    "Transaction Failed"
            );
        }

        con.close();
    }
    */

    // Task 34
    static void task34() {

        System.out.println(
                "Run Module Files Separately"
        );
    }

    // Task 35
    static void task35() {

        System.out.println(
                "Run server.java and client.java separately"
        );
    }

    // Task 36
    static void task36() {

        try {

            HttpClient client =
                    HttpClient.newHttpClient();

            HttpRequest request =
                    HttpRequest.newBuilder()
                            .uri(
                                    URI.create(
                                            "https://api.github.com"
                                    )
                            )
                            .build();

            HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers.ofString()
                    );

            System.out.println(
                    "Status Code = "
                            + response.statusCode()
            );

            System.out.println(
                    response.body()
            );

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    // Task 37
    static void task37() {

        System.out.println(
                "Use javap -c ClassName"
        );
    }

    // Task 38
    static void task38() {

        System.out.println(
                "Use JD-GUI or CFR Tool"
        );
    }

    // Task 39
    static class Test {

        public void show(String msg) {

            System.out.println(msg);
        }
    }

    static void task39() throws Exception {

        Class<?> cls =
                Class.forName(
                        "AllJavaTasks$Test"
                );

        for (Method m :
                cls.getDeclaredMethods()) {

            System.out.println(
                    m.getName()
                            + Arrays.toString(
                            m.getParameters()
                    )
            );
        }

        Object obj =
                cls.getDeclaredConstructor()
                        .newInstance();

        Method method =
                cls.getDeclaredMethod(
                        "show",
                        String.class
                );

        method.invoke(
                obj,
                "Hello Reflection"
        );
    }

    // Task 40
static void task40() throws Exception {

    long start = System.currentTimeMillis();

    List<Thread> threads = new ArrayList<>();

    for (int i = 1; i <= 10; i++) {

        int num = i;

        Thread t = Thread.startVirtualThread(() -> {

            System.out.println(
                    "Virtual Thread " + num + " : "
                    + Thread.currentThread()
            );

        });

        threads.add(t);
    }

    for (Thread t : threads) {
        t.join();
    }

    long end = System.currentTimeMillis();

    System.out.println(
            "Execution Time = "
            + (end - start) + " ms"
    );
}
    // Task 41
    static void task41() throws Exception {

        ExecutorService service =
                Executors.newFixedThreadPool(3);

        List<Callable<Integer>> tasks =
                new ArrayList<>();

        tasks.add(() -> 10 + 20);
        tasks.add(() -> 30 + 40);
        tasks.add(() -> 50 + 60);

        List<Future<Integer>> results =
                service.invokeAll(tasks);

        for (Future<Integer> f : results) {

            System.out.println(f.get());
        }

        service.shutdown();
    }

    public static void main(String[] args)
            throws Exception {

        AllJavaTasks obj =
                new AllJavaTasks();

        task1();

        task6();

        task7();

        task8();

        System.out.println(
                fibonacci(6)
        );

        System.out.println(
                obj.add(10,20)
        );

        System.out.println(
                obj.add(5.5,4.5)
        );

        System.out.println(
                obj.add(1,2,3)
        );

        Car car = new Car();

        car.make = "Toyota";
        car.model = "Camry";
        car.year = 2022;

        car.displayDetails();

        Animal animal = new Animal();

        Dog dog = new Dog();

        animal.makeSound();

        dog.makeSound();

        Guitar guitar = new Guitar();

        Piano piano = new Piano();

        guitar.play();

        piano.play();

        try {

            checkAge(20);

        } catch (InvalidAgeException e) {

            System.out.println(
                    e.getMessage()
            );
        }

        MyThread t1 = new MyThread();

        MyThread t2 = new MyThread();

        t1.start();

        t2.start();

        task27();

        task28();

        task29();

        task30(10);

        task30("Hello");

        task30(25.5);

        task34();

        task35();

        task37();

        task38();

        task39();

        task40();

        task41();
    }
}