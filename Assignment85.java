import java.util.HashSet;
import java.util.Set;

    class TransactionException extends Exception {
        public TransactionException(String message) {
            super(message);
        }
    }

    class TransactionProcessor {
        public void processTransaction(String transactionId) throws TransactionException {
            try {
                if (transactionId == null) {
                    throw new TransactionException("Invalid transaction ID: null");
                }
                System.out.println("Transaction processed successfully.");
            } catch (Exception e) {
                throw new TransactionException("Error processing transaction " + transactionId + ": " + e.getMessage());
            }
        }

        public static void main(String[] args) {
            TransactionProcessor processor = new TransactionProcessor();
            try {
                processor.processTransaction("12345");
                processor.processTransaction(null); // Simulating an invalid transaction
            } catch (TransactionException e) {
                System.err.println("Transaction error: " + e.getMessage());
            }
        }
    }

