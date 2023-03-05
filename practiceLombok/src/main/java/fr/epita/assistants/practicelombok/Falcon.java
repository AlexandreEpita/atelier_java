package fr.epita.assistants.practicelombok;

import lombok.*;
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"name", "nickname", "speed"})
public class Falcon {
    String name;
    String nickname;
    int speed;
}
