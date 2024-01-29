public class Worker {
    static public final int TASK_FAILED_NUMBER = 33 - 1;
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == TASK_FAILED_NUMBER) {
                errorCallback.onError(ANSI_RED + "Task " + i + " is failed!" + ANSI_RESET);
                continue;
            }
            callback.onDone("Task " + i + " is done");
        }
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
}
