package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private SmartDoorLock smartDoorLock;
    private static int INITIAL_FAILED_ATTEMPTS = 0;

    @BeforeEach
    void beforeEach(){
        this.smartDoorLock = new SmartDoorLockImpl();
    }

    @Test
    public void isInitiallyUnlocked() {
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void isInitiallyNotBlocked(){
        assertFalse(smartDoorLock.isBlocked());
    }

    @Test
    public void initialFailedAttempts(){
        assertEquals(INITIAL_FAILED_ATTEMPTS, smartDoorLock.getFailedAttempts());
    }
}
