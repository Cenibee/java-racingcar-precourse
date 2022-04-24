package racingcar.racing;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.DisplayedParameterizedTest;
import racingcar.car.Car;

public class RacingTest {

    static private List<Car> cars;
    static private Car kiaCar;
    static private Car hyundaiCar;

    @BeforeAll
    static void before() {
        kiaCar = new Car("kia");
        hyundaiCar = new Car("현대");
        cars = asList(kiaCar, hyundaiCar);
    }

    @Test
    void 레이싱_생성_테스트() {
        int maxRacingRound = 10;

        Racing racing = new Racing(cars, 10);

        assertThat(racing.getMaxRacingRound()).isEqualTo(maxRacingRound);
        assertThat(racing.getRacingLines())
                .extracting("racingCar")
                .containsExactly(kiaCar, hyundaiCar);
    }

    @DisplayedParameterizedTest
    @MethodSource("레이싱_생성_예외_케이스")
    void 레이싱_생성_예외_테스트(List<Car> cars, int maxRacingRound, String errorMessage) {
        assertThatThrownBy(() -> new Racing(cars, maxRacingRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    static List<Arguments> 레이싱_생성_예외_케이스() {
        return asList(
                Arguments.of(null, 1, "레이싱을 생성하기 위한 자동차 리스트가 null 입니다"),
                Arguments.of(emptyList(), 1, "레이싱을 위해서는 1대 이상의 자동차가 필요합니다"),
                Arguments.of(cars, 0, "레이싱은 1 회 이상 진행해야합니다")
        );
    }

}
