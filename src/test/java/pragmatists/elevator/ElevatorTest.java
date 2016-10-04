package pragmatists.elevator;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class ElevatorTest {

    @Test
    public void exists() throws Exception {
        assertThat(new Elevator()).isNotNull();
    }
}
