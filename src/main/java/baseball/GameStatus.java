package baseball;

import java.util.Arrays;

public enum GameStatus {
    PLAY("1"),
    END("2");

    private final String input;

    GameStatus(String input) {
        this.input = input;
    }

    public boolean isPlay() {
        return this == PLAY;
    }

    public static GameStatus from(String input) {
        return Arrays.stream(values())
            .filter(gameStatus -> gameStatus.input.equals(input))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}