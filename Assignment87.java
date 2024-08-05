import java.io.Closeable;
import java.io.IOException;

class ConnectionManager implements Closeable {
    public void openConnection() {
        System.out.println("Connection opened.");
    }

    @Override
    public void close() throws IOException {
        System.out.println("Connection closed.");
    }

    public static void main(String[] args) {
        try (ConnectionManager connection = new ConnectionManager()) {
            connection.openConnection();
            throw new RuntimeException("Oops, something went wrong!");
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
