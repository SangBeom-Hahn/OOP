package jacoco;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class MoimTest {
    @Test
    @DisplayName("")
    void MoimTest() {
        Moim moim = new Moim();
        moim.maxNumberOfAttendees = 100;
        moim.numberOfEnollment = 10;
        Assert.assertFalse(moim.isEnrollmentFull());
    }
}