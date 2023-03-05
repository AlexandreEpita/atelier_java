package fr.epita.assistants.scheduler;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

public class MyTask<INPUT_TYPE, RETURN_TYPE> implements Task<RETURN_TYPE> {

    private CompletableFuture<RETURN_TYPE> future;

    public MyTask(CompletableFuture<RETURN_TYPE> future) {
        this.future = future;
    }

    static <RETURN_TYPE> Task<RETURN_TYPE> of(Supplier<RETURN_TYPE> actionSupplier) {
        CompletableFuture<RETURN_TYPE> fut = CompletableFuture.supplyAsync(actionSupplier);
        return new MyTask<>(fut);
    }

    @Override
    public CompletableFuture<RETURN_TYPE> build() {
        return future;
    }

    @Override
    public Task<RETURN_TYPE> onErrorRecoverWith(Function<Throwable, RETURN_TYPE> recoveryFunction) {
        future = future.handle((i, e) -> recoveryFunction.apply(e));
        return this;
    }

    @Override
    public <NEW_RETURN_TYPE> Task<NEW_RETURN_TYPE> andThenDo(Function<RETURN_TYPE, NEW_RETURN_TYPE> action) {
        return new MyTask<>(future.thenCompose((i) -> CompletableFuture.supplyAsync(() -> action.apply(i))));
    }

    @Override
    public Task<RETURN_TYPE> andThenWait(long number, TimeUnit timeUnit) {
        future = future.thenApplyAsync((i) -> i, CompletableFuture.delayedExecutor(number, timeUnit));
        return this;
    }
}
