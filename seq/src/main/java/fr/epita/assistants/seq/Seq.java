package fr.epita.assistants.seq;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

@FunctionalInterface
public interface Seq<T> extends ExtendedStream<T>{

    Stream<T> my_stream();
    static <T> Seq<T> of (List<T> list)
    {
        return () -> list.stream();
    }

    static <T> Seq<T> of (T ...value)
    {
        return () -> Arrays.stream(value).sequential();
    }

    static <T> Seq<T> of (Stream<T> stream)
    {
        return () -> stream;
    }
    @Override
    default <KEY_TYPE> Map<KEY_TYPE, T> toMap(final Function<T, KEY_TYPE> keyMapper) {
        Map<KEY_TYPE, T> res = new HashMap<>();
        my_stream().forEach(i -> res.put(keyMapper.apply(i), i));
        return res;
    }

    @Override
    default <KEY_TYPE, VALUE_TYPE, MAP_TYPE extends Map<KEY_TYPE, VALUE_TYPE>> MAP_TYPE toMap(final MAP_TYPE map,
                                                                                              final Function<T,
                                                                                                      KEY_TYPE> keyMapper, final Function<T, VALUE_TYPE> valueMapper) {
        my_stream().forEach(i -> map.put(keyMapper.apply(i), valueMapper.apply(i)));
        return map;
    }

    @Override
    default <KEY_TYPE, VALUE_TYPE> Map<KEY_TYPE, VALUE_TYPE> toMap(final Function<T, KEY_TYPE> keyMapper,
                                                                   final Function<T, VALUE_TYPE> valueMapper) {
        Map<KEY_TYPE, VALUE_TYPE> res = new HashMap<>();
        my_stream().forEach(i -> res.put(keyMapper.apply(i), valueMapper.apply(i)));
        return res;
    }

    @Override
    default List<T> toList() {
        return my_stream().toList();
    }

    @Override
    default <LIST extends List<T>> LIST toList(final LIST list) {
        my_stream().forEach(i -> list.add(list.size(), i));
        return list;
    }

    @Override
    default Set<T> toSet() {
        return my_stream().collect(Collectors.toSet());
    }

    @Override
    default <SET extends Set<T>> SET toSet(final SET set) {
        my_stream().forEach(i -> set.add(i));
        return set;
    }

    @Override
    default <ASSOCIATED_TYPE> ExtendedStream<Pair<T, ASSOCIATED_TYPE>> associate(final Supplier<ASSOCIATED_TYPE> supplier) {
        List<Pair<T, ASSOCIATED_TYPE>> list = new ArrayList<>();
        my_stream().forEach(i -> list.add(new Pair<T, ASSOCIATED_TYPE>(i, supplier.get())));
        return Seq.of(list);
    }

    @Override
    default <ASSOCIATED_TYPE> ExtendedStream<Pair<T, ASSOCIATED_TYPE>> associate(final Stream<ASSOCIATED_TYPE> supplier) {

        List<ASSOCIATED_TYPE> list = new ArrayList<>();
        supplier.forEach(a -> list.add(a));

        List<T> asso = toList();
        List stock = new ArrayList<>();
        int i = 0;
        while (i < list.size() && i < asso.size())
        {
            Pair<T, ASSOCIATED_TYPE> pair = new Pair<>(asso.get(i), list.get(i));
            stock.add(pair);
            i++;
        }

        return Seq.of(stock);
    }

    @Override
    default ExtendedStream<T> print() {
        my_stream().forEach(i -> System.out.println(i));
        return of(my_stream());
    }

    @Override
    default ExtendedStream<T> plus(final Stream<T> stream) {
        return of(Stream.concat(my_stream(), stream));
    }

    @Override
    default String join(final String delimiter) {
        String res = my_stream().reduce("", (acc, i) -> acc + i.toString() + delimiter, String::concat);
        return res.substring(0, res.length() - delimiter.length());
    }

    @Override
    default String join() {
        return my_stream().reduce("", (acc, i) -> acc + i.toString(), String::concat);
    }

    @Override
    default <KEY_TYPE> ExtendedStream<Pair<KEY_TYPE, ExtendedStream<T>>> partition(final Function<T, KEY_TYPE> pivot) {
        Map<KEY_TYPE, List<T>> hashMap = new HashMap<>();

        my_stream().forEach(i ->
        {
            if (!hashMap.containsKey(pivot.apply(i)))
            {
                List<T> list = new ArrayList<>();
                list.add(i);
                hashMap.put(pivot.apply(i), list);
                return;
            }
            hashMap.get(pivot.apply(i)).add(i);
        });

        List list = new ArrayList<>();
        hashMap.forEach((k, v) -> list.add(new Pair<>(k, Seq.of(v))));
        return Seq.of(list);
    }

    @Override
    default Stream<T> filter(Predicate<? super T> predicate) {
        return my_stream().filter(predicate);
    }

    @Override
    default <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
        return my_stream().map(mapper);
    }

    @Override
    default IntStream mapToInt(ToIntFunction<? super T> mapper) {
        return my_stream().mapToInt(mapper);
    }

    @Override
    default LongStream mapToLong(ToLongFunction<? super T> mapper) {
        return my_stream().mapToLong(mapper);
    }

    @Override
    default DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        return my_stream().mapToDouble(mapper);
    }

    @Override
    default <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return my_stream().flatMap(mapper);
    }

    @Override
    default IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return my_stream().flatMapToInt(mapper);
    }

    @Override
    default LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        return my_stream().flatMapToLong(mapper);
    }

    @Override
    default DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return my_stream().flatMapToDouble(mapper);
    }

    @Override
    default Stream<T> distinct() {
        return my_stream().distinct();
    }

    @Override
    default Stream<T> sorted() {
        return my_stream().sorted();
    }

    @Override
    default Stream<T> sorted(Comparator<? super T> comparator) {
        return my_stream().sorted(comparator);
    }

    @Override
    default Stream<T> peek(Consumer<? super T> action) {
        return my_stream().peek(action);
    }

    @Override
    default Stream<T> limit(long maxSize) {
        return my_stream().limit(maxSize);
    }

    @Override
    default Stream<T> skip(long n) {
        return my_stream().skip(n);
    }

    @Override
    default void forEach(Consumer<? super T> action) {
        my_stream().forEach(action);
    }

    @Override
    default void forEachOrdered(Consumer<? super T> action) {
        my_stream().forEachOrdered(action);
    }

    @Override
    default Object[] toArray() {
        return my_stream().toArray();
    }

    @Override
    default <A> A[] toArray(IntFunction<A[]> generator) {
        return my_stream().toArray(generator);
    }

    @Override
    default T reduce(T identity, BinaryOperator<T> accumulator) {
        return my_stream().reduce(identity, accumulator);
    }

    @Override
    default Optional<T> reduce(BinaryOperator<T> accumulator) {
        return my_stream().reduce(accumulator);
    }

    @Override
    default <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        return my_stream().reduce(identity, accumulator, combiner);
    }

    @Override
    default <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return my_stream().collect(supplier,accumulator, combiner);
    }

    @Override
    default <R, A> R collect(Collector<? super T, A, R> collector) {
        return my_stream().collect(collector);
    }

    @Override
    default Optional<T> min(Comparator<? super T> comparator) {
        return my_stream().min(comparator);
    }

    @Override
    default Optional<T> max(Comparator<? super T> comparator) {
        return my_stream().max(comparator);
    }

    @Override
    default long count() {
        return my_stream().count();
    }

    @Override
    default boolean anyMatch(Predicate<? super T> predicate) {
        return my_stream().anyMatch(predicate);
    }

    @Override
    default boolean allMatch(Predicate<? super T> predicate) {
        return my_stream().allMatch(predicate);
    }

    @Override
    default boolean noneMatch(Predicate<? super T> predicate) {
        return my_stream().noneMatch(predicate);
    }

    @Override
    default Optional<T> findFirst() {
        return my_stream().findFirst();
    }

    @Override
    default Optional<T> findAny() {
        return my_stream().findAny();
    }

    @Override
    default Iterator<T> iterator() {
        return my_stream().iterator();
    }

    @Override
    default Spliterator<T> spliterator() {
        return my_stream().spliterator();
    }

    @Override
    default boolean isParallel() {
        return my_stream().isParallel();
    }

    @Override
    default Stream<T> sequential() {
        return my_stream().sequential();
    }

    @Override
    default Stream<T> parallel() {
        return my_stream().parallel();
    }

    @Override
    default Stream<T> unordered() {
        return my_stream().unordered();
    }

    @Override
    default Stream<T> onClose(Runnable closeHandler) {
        return my_stream().onClose(closeHandler);
    }

    @Override
    default void close() {
        my_stream().close();
    }
}