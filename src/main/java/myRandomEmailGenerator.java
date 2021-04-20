import org.apache.commons.lang3.RandomStringUtils;

public class myRandomEmailGenerator {
    public String generateEmail() {
        return RandomStringUtils.randomAlphanumeric(4, 20) + "@gmail.com";
    }
}
