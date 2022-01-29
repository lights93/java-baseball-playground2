package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.EnumMap;
import java.util.Map;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ComputerTest {
    @ParameterizedTest
    @CsvSource({"123,3,0,0", "124,2,0,1",
        "145,1,0,2", "132,1,2,0", "134,1,1,1",
        "231,0,3,0", "234, 0,2,1", "734,0,1,2", "456,0,0,3"})
    void name(String input, int strike, int ball, int nothing) {
        BaseballNumbers baseballNumbers = BaseballNumbers.from("123");
        Computer computer = new Computer(baseballNumbers);

        HintResult hintResult = computer.calculateHint(BaseballNumbers.from(input));

        Map<Hint, Integer> hints = new EnumMap<>(Hint.class);
        hints.put(Hint.STRIKE, strike);
        hints.put(Hint.BALL, ball);
        hints.put(Hint.NOTHING, nothing);

        assertThat(hintResult).isEqualTo(HintResult.from(hints));
    }
}
