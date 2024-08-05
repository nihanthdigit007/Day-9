import java.util.HashSet;
import java.util.Set;

class DataProcessor {
        public void processData(String data) throws CustomCheckedException {
            if (data == null) {
                throw new CustomCheckedException("Data cannot be null.");
            }
            System.out.println("Data processed successfully.");
        }

        public void processUncheckedData(String data) {
            if (data.isEmpty()) {
                throw new CustomUncheckedException("Unchecked: Data is empty.");
            }
            System.out.println("Unchecked data processed successfully.");
        }

        public static void main(String[] args) {
            DataProcessor processor = new DataProcessor();

            try {
                processor.processData("Valid data");
                processor.processData(null);
            } catch (CustomCheckedException e) {
                System.err.println("Checked exception: " + e.getMessage());
            }

            try {
                processor.processUncheckedData("Valid unchecked data");
                processor.processUncheckedData("");
            } catch (CustomUncheckedException e) {
                System.err.println("Unchecked exception: " + e.getMessage());
            }
        }
    }

    class CustomCheckedException extends Exception {
        public CustomCheckedException(String message) {
            super(message);
        }
    }

    class CustomUncheckedException extends RuntimeException {
        public CustomUncheckedException(String message) {
            super(message);
        }
    }
