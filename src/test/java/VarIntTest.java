import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class VarIntTest {

    private VarInt varInt;

    @Before
    public void init() {
        varInt = new VarInt();
    }

    @Test
    public void should_find_for_1() {
        assertThat(varInt.from(1)).isEqualTo("00000001");
    }

    @Test
    public void should_find_for_127() {
        assertThat(varInt.from(127)).isEqualTo("01111111");
    }

    @Test
    public void should_find_for_128() {
        assertThat(varInt.from(128)).isEqualTo("1000000000000001");
    }

    @Test
    public void should_find_for_300() {
        assertThat(varInt.from(300)).isEqualTo("1010110000000010");
    }

    @Test
    public void should_find_for_16383() {
        assertThat(varInt.from(16383)).isEqualTo("1111111101111111");
    }

    @Test
    public void should_find_for_16384() {
        assertThat(varInt.from(16384)).isEqualTo("100000001000000000000001");
    }

    @Test
    public void should_find_for_2097152() {
        assertThat(varInt.from(2097152)).isEqualTo("10000000100000001000000000000001");
    }

}
