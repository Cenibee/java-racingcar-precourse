package racingcar.racing;

import racingcar.car.Car;

public class RacingLine {

    private final Car racingCar;
    private int position;

    public RacingLine(Car car) {
        assertRacingCar(car);

        this.racingCar = car;
        position = 0;
    }

    public Car getRacingCar() {
        return racingCar;
    }

    public int getPosition() {
        return position;
    }

    private void assertRacingCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("자동차는 null 일 수 없습니다");
        }
    }

    public String getRacingCarName() {
        return this.racingCar.getName();
    }
}
