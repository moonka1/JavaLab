import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        TaskService service = new TaskService(executor);

        service.getDataAsync()
                .thenApply(service::modifyData)
                .handle((result, error) -> {
                    if (error != null) {
                        return service.recover(error);
                    }
                    return result;
                })
                .thenAccept(res -> System.out.println("Output: " + res))
                .join();

        executor.shutdown();
    }
}