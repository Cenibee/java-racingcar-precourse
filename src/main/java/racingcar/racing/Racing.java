package racingcar.racing;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;

public class Racing {
    final List<RacingLine> racingLines;
    final int maxRacingRound;
    private int currentRacingRound;

    public Racing(List<Car> cars, int maxRacingRound) {
        assertMaxRacingRound(maxRacingRound);
        this.maxRacingRound = maxRacingRound;
        this.racingLines = toRacingLines(cars);
        this.currentRacingRound = 0;
    }

    public List<RacingLine> getRacingLines() {
        return racingLines;
    }

    public int getMaxRacingRound() {
        return this.maxRacingRound;
    }

    public void play() {
        increaseRacingRound();
        for (RacingLine racingLine : racingLines) {
            racingLine.goStraight();
        }
    }

    private void increaseRacingRound() {
        if (isRacingEnd()) {
            throw new IllegalStateException("이미 종료된 레이싱입니다");
        }
        currentRacingRound++;
    }

    public boolean isRacingEnd() {
        return currentRacingRound >= maxRacingRound;
    }

    private List<RacingLine> toRacingLines(List<Car> cars) {
        assertRacingCars(cars);

        List<RacingLine> toRacingLines = new ArrayList<>(cars.size());

        for (Car car : cars) {
            toRacingLines.add(new RacingLine(car));
        }

        return toRacingLines;
    }

    private void assertRacingCars(List<Car> cars) {
        if (cars == null) {
            throw new IllegalArgumentException("레이싱을 생성하기 위한 자동차 리스트가 null 입니다");
        } else if (cars.isEmpty()) {
            throw new IllegalArgumentException("레이싱을 위해서는 1대 이상의 자동차가 필요합니다");
        }
    }

    private void assertMaxRacingRound(int maxRacingRound) {
        if (maxRacingRound < 1) {
            throw new IllegalArgumentException("레이싱은 1 회 이상 진행해야합니다");
        }
    }
}
