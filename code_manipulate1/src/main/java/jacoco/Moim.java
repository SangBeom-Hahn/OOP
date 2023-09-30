package jacoco;

public class Moim {
    int maxNumberOfAttendees;
    
    int numberOfEnollment;
    
    public boolean isEnrollmentFull() {
        if (maxNumberOfAttendees == 0) {
            return false;
        }
    
        if (numberOfEnollment < maxNumberOfAttendees) {
            return false;
        }
        
        return true;
    }
}
