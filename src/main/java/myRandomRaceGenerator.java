import java.util.Random;

public class myRandomRaceGenerator {
    public Race generateRace() {
        Random random = new Random();
        switch (random.nextInt(4)) {
            case 0 -> {
                return Race.CAUCASIAN;
            }
            case 1 -> {
                return Race.AUSTRALOID;
            }
            case 2 -> {
                return Race.NEGROID;
            }
            case 3 -> {
                return Race.MONGOLOID;
            }
            default -> {
                return null;
            }
        }
    }
}
