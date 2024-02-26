package edp;

public class Excepciones {
    public static class DuplicateKeyException extends Exception{
        public DuplicateKeyException(String message){
            super(message);
        }
    }

    public static class KeyNotFoundException extends Exception {
        public KeyNotFoundException(String message) {
            super(message);
        }
    }

    public static class EmptyDictionaryException extends Exception {
        public EmptyDictionaryException(String message) {
            super(message);
        }
    }

    public static class IndexOutOfRangeException extends Exception {
        public IndexOutOfRangeException(String message) {
            super(message);
        }
    }

}
