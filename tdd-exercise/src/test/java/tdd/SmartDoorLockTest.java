package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private SmartDoorLock smartDoorLock;

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
}
