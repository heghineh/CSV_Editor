import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Service {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Person> people = new ArrayList<>(getPeopleList());
    FileWriter fileWriter = new FileWriter();

    public ArrayList<Person> getPeopleList() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("367-77-1044", "Helena", "Kris", "Thu Sep 24 06:49:52 PDT 1998", Race.NEGROID, "1-012-127-5255 x104", "uMNHFv0@gmail.com"));
        people.add(new Person("343-22-3211", "Sharen", "Robel", "Thu Oct 19 20:19:19 PDT 1989", Race.CAUCASIAN, "1-780-265-7306", "4PCs@gmail.com"));
        people.add(new Person("123-13-1243", "Wilton", "Strosin", "Sat Feb 02 19:02:28 PST 1957", Race.AUSTRALOID, "1-402-066-1598", "ESw8gIU@gmail.com"));
        people.add(new Person("675-12-3124", "Honey", "Lubowitz", "Fri Apr 18 12:12:00 PDT 2003", Race.MONGOLOID, "865.026.0569", "pfu0@gmail.com"));
        people.add(new Person("109-24-9843", "Jone", "Hermiston", "Sat Nov 04 18:53:14 PST 1995", Race.CAUCASIAN, "(753) 942-9741", "LXNNq6phi4Wb@gmail.com"));

        return people;
    }

    //----------------------------------------------------------------------------------------------------------------------
    public void create() {
        Faker faker = new Faker();
        myRandomRaceGenerator myRandomRaceGenerator = new myRandomRaceGenerator();
        myRandomEmailGenerator myRandomEmailGenerator = new myRandomEmailGenerator();

        people.add(new Person(
                faker.idNumber().valid(),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.date().birthday().toString(),
                myRandomRaceGenerator.generateRace(),
                faker.phoneNumber().phoneNumber(),
                myRandomEmailGenerator.generateEmail()));

        fileWriter.writeToFile(people);
    }

    //----------------------------------------------------------------------------------------------------------------------
    public void read() {
        Stream<Person> stream = people.stream();
        System.out.println("Enter ID to find the owner's name:");
        String ID = scanner.nextLine();

        List<Person> findName = stream
                .filter(each -> each.getID().equals(ID))
                .collect(Collectors.toList());

        findName.forEach(each -> System.out.println(each.getName()));
    }

    //----------------------------------------------------------------------------------------------------------------------
    public void updateName() {
        System.out.println("Enter ID to change the parameter: ");
        String ID = scanner.nextLine();
        Stream<Person> stream1 = people.stream();

        List<Person> findName = stream1
                .filter(each -> each.getID().equals(ID))
                .collect(Collectors.toList());

        System.out.println("Enter the new name.");
        String name = scanner.nextLine();
        findName.forEach(each -> each.setName(name));

        fileWriter.writeToFile(people);
    }

    public void updateSurname() {
        System.out.println("Enter ID to change the parameter: ");
        String ID = scanner.nextLine();
        Stream<Person> stream2 = people.stream();

        List<Person> findName = stream2
                .filter(each -> each.getID().equals(ID))
                .collect(Collectors.toList());

        System.out.println("Enter the new surname.");
        String surname = scanner.nextLine();
        findName.forEach(each -> each.setSurname(surname));

        fileWriter.writeToFile(people);
    }

    public void updateDate() {
        System.out.println("Enter ID to change the parameter: ");
        String ID = scanner.nextLine();
        Stream<Person> stream3 = people.stream();

        List<Person> findName = stream3
                .filter(each -> each.getID().equals(ID))
                .collect(Collectors.toList());

        System.out.println("Enter the new date of birth:");
        String dateOfBirth = scanner.nextLine();
        findName.forEach(each -> each.setDate(dateOfBirth));

        fileWriter.writeToFile(people);
    }

    public void updateRace() {
        System.out.println("Enter ID to change the parameter:");
        String ID = scanner.nextLine();
        Stream<Person> stream4 = people.stream();

        List<Person> findName = stream4
                .filter(each -> each.getID().equals(ID))
                .collect(Collectors.toList());

        System.out.println("""
                Enter the new race.
                1 for CAUCASIAN.
                2 for NEGROID.
                3 for AUSTRALOID.
                4 for MONGOLOID.
                Any other case for random race. """);
        switch (scanner.nextInt()) {
            case 1 -> findName.forEach(each -> each.setRace(Race.CAUCASIAN));
            case 2 -> findName.forEach(each -> each.setRace(Race.NEGROID));
            case 3 -> findName.forEach(each -> each.setRace(Race.AUSTRALOID));
            case 4 -> findName.forEach(each -> each.setRace(Race.MONGOLOID));
            default -> {
                myRandomRaceGenerator myRandomRaceGenerator = new myRandomRaceGenerator();
                findName.forEach(each -> each.setRace(myRandomRaceGenerator.generateRace()));
            }
        }
        fileWriter.writeToFile(people);
    }

    public void updateNumber() {
        System.out.println("Enter ID to change the parameter:");
        String ID = scanner.nextLine();
        Stream<Person> stream5 = people.stream();

        List<Person> findName = stream5
                .filter(each -> each.getID().equals(ID))
                .collect(Collectors.toList());

        System.out.println("Enter the new phone number:");
        String phoneNumber = scanner.nextLine();
        findName.forEach(each -> each.setPhoneNumber(phoneNumber));

        fileWriter.writeToFile(people);
    }

    public void updateEmail() {
        System.out.println("Enter ID to change the parameter:");
        String ID = scanner.nextLine();
        Stream<Person> stream6 = people.stream();

        List<Person> findName = stream6
                .filter(each -> each.getID().equals(ID))
                .collect(Collectors.toList());

        System.out.println("Enter the new email address:");
        String email = scanner.nextLine();
        findName.forEach(each -> each.setPhoneNumber(email));

        fileWriter.writeToFile(people);
    }

    //----------------------------------------------------------------------------------------------------------------------
    public void delete() {
        Stream<Person> stream7 = people.stream();
        System.out.println("Enter the person's ID you want to remove:");
        String ID = scanner.nextLine();

        ArrayList<Person> findName = (ArrayList<Person>) stream7
                .filter(each -> !each.getID().equals(ID))
                .collect(Collectors.toList());

        fileWriter.writeToFile(findName);
    }

    //----------------------------------------------------------------------------------------------------------------------
    public void quit() {
        fileWriter.writeToFile(people);
    }
}