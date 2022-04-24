package racingcar.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.car.Car;

class RacingLineTest {

    @Test
    void 레이싱_라인_생성_테스트() {
        Car car = new Car("car");
        RacingLine racingLine = new RacingLine(car);

        assertThat(racingLine.getRacingCar()).isEqualTo(car);
        assertThat(racingLine.getPosition()).isEqualTo(0);
    }

    @Test
    void 레이싱_라인_생성_예외_테스트() {
        assertThatThrownBy(() -> new RacingLine(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 null 일 수 없습니다");
    }

}