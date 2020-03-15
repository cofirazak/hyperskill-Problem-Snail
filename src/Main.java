import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            int distance = scanner.nextInt();
            int daySteps = scanner.nextInt();
            int nightSteps = scanner.nextInt();
            // Linear equation form task description:
            // (daySteps - nightSteps) * X + nightSteps = distance.

            // Formula for solving this Linear equation with floating point precision:
            // X = (distance - nightSteps) / (daySteps - nightSteps)

            // Formula for solving this with integer precision(in respect of java truncating integer divisions):
            // X = (distance - nightSteps - 1) / (daySteps - nightSteps) + 1
            System.out.println((distance - nightSteps - 1) / (daySteps - nightSteps) + 1);
        }

    }
}
