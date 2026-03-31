import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class TaskService {

    private final ExecutorService executor;

    public TaskService(ExecutorService executor) {
        this.executor = executor;
    }

    public CompletableFuture<String> getDataAsync() {
        return CompletableFuture.supplyAsync(() -> {
            pause();

            if (Math.random() < 0.5) {
                throw new RuntimeException("Data error occurred");
            }

            return "initial data";
        }, executor);
    }

    public String modifyData(String data) {
        return data + " -> modified";
    }

    public String recover(Throwable error) {
        return "backup data";
    }

    private void pause() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}