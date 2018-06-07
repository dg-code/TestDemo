package demo.example.SimpleTestProject.Utils;

public class Utils {	
    public static class Argument {
        public static void isNotNull(Object argument, String argumentName) {
            if (argument == null)
                throw new IllegalArgumentException(argumentName + " cannot be null.");
        }
    }
}
