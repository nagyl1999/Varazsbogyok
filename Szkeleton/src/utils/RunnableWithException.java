package utils;

@FunctionalInterface
public interface RunnableWithException {
    public abstract void run() throws Exception;  
}
