
public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        FileWriter fileWriter = new FileWriter();
        fileWriter.writeToFile(service.getPeopleList());

        Controller controller = new Controller();
    }
}