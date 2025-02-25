package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private SmartDoorLock smartDoorLock;
    private static final int INITIAL_FAILED_ATTEMPTS = 0;
    private final static Random RANDOM = new Random();

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
        return RANDOM.nextInt(SmartDoorLockImpl.MIN_PIN_ALLOWED, SmartDoorLockImpl.MAX_PIN_ALLOWED + 1);
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

    private void lockSmartDoorLock(int pin) {
        smartDoorLock.setPin(pin);
        smartDoorLock.lock();
    }

    @Test
    public void tryLockWithCorrectPin(){
        int correctPin = generateCorrectPin();
        lockSmartDoorLock(correctPin);
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void tryUnlockWithCorrectPin(){
        int correctPin = generateCorrectPin();
        lockSmartDoorLock(correctPin);

        smartDoorLock.unlock(correctPin);
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void tryUnlockWithWrongPin(){
        int firstPin = SmartDoorLockImpl.MIN_PIN_ALLOWED;
        int secondPin = SmartDoorLockImpl.MIN_PIN_ALLOWED + 1;

        lockSmartDoorLock(firstPin);

        smartDoorLock.unlock(secondPin);
        assertTrue(smartDoorLock.isLocked());
    }

    private void failUnlock(){
        int correctPin = generateCorrectPin();
        int wrongPin = SmartDoorLockImpl.MAX_PIN_ALLOWED + 1;

        lockSmartDoorLock(correctPin);
        smartDoorLock.unlock(wrongPin);
    }

    @Test
    public void failedAttempt(){
        int failedAttempts = INITIAL_FAILED_ATTEMPTS;
        failUnlock();
        failedAttempts += 1;
        assertEquals(failedAttempts, smartDoorLock.getFailedAttempts());
    }

    private void blockSmartLock() {
        for(int times = 0; times < SmartDoorLockImpl.MAX_FAILED_ATTEMPTS; times++){
            failUnlock();
        }
    }

    @Test
    public void doesSmartLockBlock(){
        blockSmartLock();
        assertTrue(smartDoorLock.isBlocked());
    }

    @Test
    public void decreasingMaxAttempts(){
        for(int times = 0; times < SmartDoorLockImpl.MAX_FAILED_ATTEMPTS; times++){
            final int expectedRemainingAttempts = SmartDoorLockImpl.MAX_FAILED_ATTEMPTS - times;
            assertEquals(expectedRemainingAttempts, smartDoorLock.getMaxAttempts());

            failUnlock();
        }
    }


}
