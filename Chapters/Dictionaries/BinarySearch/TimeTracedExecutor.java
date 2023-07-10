package Dictionaries.BinarySearch;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;
import java.util.logging.Logger;

public class TimeTracedExecutor<T,R> {
    Function<T,R> methodToExecute;

    public TimeTracedExecutor(Function<T, R> methodToExecute) {
        this.methodToExecute = methodToExecute;
    }

    public R executeWithInput(String taskDescription, T t, Logger logger){
        Instant start = Instant.now();
        R r= methodToExecute.apply(t);
        Instant finish = Instant.now();
        String format = "It took %s milliseconds to " + taskDescription;
        String elapsedTime = NumberFormat.getNumberInstance().format(Duration.between(start, finish).toMillis());
        logger.info(String.format(format, elapsedTime));
        return r;
    }
}
