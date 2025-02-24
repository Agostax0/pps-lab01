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

    @Test
    public void failedLockWithNoPin(){
        smartDoorLock.lock();
        assertFalse(smartDoorLock.isLocked());
    }

    private int generateCorrectPin(){
        return (int) (SmartDoorLockImpl.MIN_PIN_ALLOWED + Math.random() * SmartDoorLockImpl.MAX_PIN_ALLOWED - SmartDoorLockImpl.MIN_PIN_ALLOWED);
    }

    @Test
    public void setCorrectPin(){
        assertDoesNotThrow(() -> smartDoorLock.setPin(generateCorrectPin()));
    }

    @Test
    public void setWrongPinUnderLowerBound(){
        int wrongPin = SmartDoorLockImpl.MIN_PIN_ALLOWED - 1;
        assertThrows(IllegalPinException.class, () -> smartDoorLock.setPin(wrongPin));
    }

    @Test
    public void setWrongPinOverUpperBound(){
        int wrongPin = SmartDoorLockImpl.MAX_PIN_ALLOWED + 1;
        assertThrows(IllegalPinException.class, () -> smartDoorLock.setPin(wrongPin));
    }

    @Test
    public void tryLockWithCorrectPin(){
        int correctPin = generateCorrectPin();
        smartDoorLock.setPin(correctPin);
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
    }

}
