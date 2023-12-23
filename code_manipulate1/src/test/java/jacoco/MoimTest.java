package jacoco;

import org.junit.Assert;
import org.junit.Test;

class MoimTest {
    @Test
    void MoimTest() {
        Moim moim = new Moim();
        moim.maxNumberOfAttendees = 100;
        moim.numberOfEnollment = 10;
        Assert.assertFalse(moim.isEnrollmentFull());
    }
}