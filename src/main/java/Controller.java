import java.util.Scanner;

public class Controller {
    Controller() {
        Scanner scanner = new Scanner(System.in);


        Service service = new Service();
        boolean finisher = true;

        while (finisher) {
            System.out.println("""                                   
                    -----------MENU-----------
                    Enter 1 to add a person.
                    Enter 2 to read the name of person with given ID.
                    Enter 3 to update the person's parameter using the ID.
                    Enter 4 to delete the given person's data.
                    Enter 5 to quit.
                    Enter any other case to exit.""");

            switch (scanner.nextInt()) {
                case 1 -> service.create();
                case 2 -> service.read();
                case 3 -> {
                    System.out.println("""                                              
                            Press the key to chose what to change.
                            1 - name.
                            2 - surname.
                            3 - date of birth.
                            4 - race.
                            5 - phone number.
                            6 - email
                            Any other key to exit.""");

                    switch (scanner.nextInt()) {
                        case 1 -> service.updateName();
                        case 2 -> service.updateSurname();
                        case 3 -> service.updateDate();
                        case 4 -> service.updateRace();
                        case 5 -> service.updateNumber();
                        case 6 -> service.updateEmail();
                        default -> service.quit();
                    }
                }
                case 4 -> service.delete();
                case 5 -> service.quit();
                default -> finisher = false;
            }
        }
    }
}