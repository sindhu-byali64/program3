import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Person {
    protected String name;
    protected LocalDate dob;

    public Person(String name, String dobStr) {
        this.name = name;
        this.dob = parseDate(dobStr);
    }

    private LocalDate parseDate(String dobStr) {
        try {
            if (dobStr.indexOf('-') == 2) {
                return LocalDate.parse(dobStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } else {
                return LocalDate.parse(dobStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
        } catch (Exception e) {
            System.out.println("Invalid date format. Use DD-MM-YYYY or YYYY-MM-DD");
            return LocalDate.now(); // fallback
        }
    }

    public void displayName() {
        System.out.println("Name: " + name);
    }

    public void displayAge() {
        int age = Period.between(dob, LocalDate.now()).getYears();
        System.out.println("Age: " + age);
    }

    // 👉 Person class main method for testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter DOB (DD-MM-YYYY or YYYY-MM-DD): ");
        String dob = sc.nextLine();

        Person person = new Person(name, dob);
        person.displayName();
        person.displayAge();

        sc.close();
    }
}