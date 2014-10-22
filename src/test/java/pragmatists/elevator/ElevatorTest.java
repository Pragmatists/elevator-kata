package pragmatists.elevator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pragmatists.elevator.Elevator.Status.AWAITING;
import static pragmatists.elevator.Elevator.Status.GOING_DOWN;
import static pragmatists.elevator.Elevator.Status.GOING_UP;

public class ElevatorTest {

    private Elevator elevator;

    private DoorsDriverSpy doorsDriver;

    @Before
    public void setUp() {
        doorsDriver = new DoorsDriverSpy();
        elevator = new Elevator(doorsDriver);
    }

    @Test
    public void shouldStartOnZeroFloor() throws Exception {

        // given:
        // when:
        int floor = elevator.currentFloor();

        // then:
        assertThat(floor).isZero();
    }

    @Test
    public void shouldStartInAwaitingState() throws Exception {

        // given:
        // when:
        Elevator.Status status = elevator.status();

        // then:
        assertThat(status).isEqualTo(AWAITING);
    }

    @Test
    public void shouldCloseDoorsAfterPushingAnyButton() throws Exception {

        // given:
        // when:
        elevator.pushButton(3);

        // then:
        assertThat(doorsDriver.doorClosingHasBeenRequested()).isTrue();
    }

    @Test
    public void shouldNotCloseDoorsAfterPushingButtonWithCurrentFloor() throws Exception {

        // given:
        // when:
        elevator.pushButton(0);

        // then:
        assertThat(doorsDriver.doorClosingHasBeenRequested()).isFalse();
    }

    @Test
    public void shouldStartGoingUpAfterDoorsHaveBeenClosed() throws Exception {

        // given:
        // when:
        elevator.pushButton(3);
        doorsDriver.doorsClosed();

        // then:
        assertThat(elevator.status()).isEqualTo(GOING_UP);
    }

    @Test
    public void shouldNotStartGoingUpUnlessDoorsHaveBeenClosed() throws Exception {

        // given:
        // when:
        elevator.pushButton(3);

        // then:
        assertThat(elevator.status()).isEqualTo(AWAITING);
    }

    @Test
    public void shouldStartGoingDownAfterDoorsHaveBeenClosed() throws Exception {

        // given:
        elevator = new Elevator(3, doorsDriver);

        // when:
        elevator.pushButton(1);
        doorsDriver.doorsClosed();

        // then:
        assertThat(elevator.status()).isEqualTo(GOING_DOWN);
    }

}
