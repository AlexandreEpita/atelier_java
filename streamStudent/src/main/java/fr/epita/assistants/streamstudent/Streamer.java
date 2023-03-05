package fr.epita.assistants.streamstudent;

import java.util.Optional;
import java.util.stream.Stream;

public class Streamer {
    public Stream<Pair<Integer, String>> validator(Stream<Pair<Integer, String>> stream) {
        return stream.filter(i -> i.getKey().intValue() <= 100 && i.getKey().intValue() >= 0).filter(j -> j.getValue().chars().filter(ch -> ch == '_').count() + j.getValue().chars().filter(ch -> ch == '.').count() == 1);
    }

    public Stream<Pair<Integer, String>> orderGrade(Stream<Pair<Integer, String>> stream) {
        return stream.sorted((i, j) -> i.getKey().compareTo(j.getKey()) == 0 ? i.getValue().compareTo(j.getValue()) : i.getKey().compareTo(j.getKey()));
    }

    public Stream<Pair<Integer, String>> lowercase(Stream<Pair<Integer, String>> stream) {
        return stream.map(i -> new Pair<>((i.getValue().chars().filter(ch -> ch >= 'A' && ch <= 'Z').count() > 0) ? i.getKey() / 2 : i.getKey(), i.getValue().toLowerCase()));
    }

    public Optional<Pair<Integer, String>> headOfTheClass(Stream<Pair<Integer, String>> stream) {
        return stream.max((i,j) -> (i.getKey().intValue() - j.getKey().intValue()) == 0 ? j.getValue().compareTo(i.getValue()) : i.getKey().intValue() - j.getKey().intValue());
    }

    public Stream<Pair<Integer, String>> quickFix(Stream<Pair<Integer, String>> stream) {
        return stream.map(i -> new Pair<>((i.getValue().toUpperCase().startsWith("MA") || (i.getValue().toUpperCase().startsWith("L") && i.getValue().toUpperCase().endsWith("X"))) ? (i.getKey() * 2 < 100 ? i.getKey() * 2 : 100) : i.getKey(), i.getValue()));
    }

    public Stream<Pair<Integer, String>> encryption(Stream<Pair<Integer, String>> stream) {
        return stream.map(i -> new Pair<>(i.getKey(), new String(i.getValue().substring((i.getValue().length() / 2), i.getValue().length()) + i.getValue().substring(0, (i.getValue().length() / 2)))));
    }


}
