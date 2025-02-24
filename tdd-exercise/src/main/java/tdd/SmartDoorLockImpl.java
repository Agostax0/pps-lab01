package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {

    private boolean isLocked = false;
    private Integer pin = null;
    public final static int MIN_PIN_ALLOWED = 1000;
    public final static int MAX_PIN_ALLOWED = 9999;
    private int failedAttempts = 0;


    @Override
    public void setPin(int pin) {
        if(pin >= MIN_PIN_ALLOWED && pin <= MAX_PIN_ALLOWED){
            this.pin = pin;
        }
        else{
            throw new IllegalPinException();
        }

    }

    @Override
    public void unlock(int pin) {
        if(this.pin == pin)
            this.isLocked = false;
        else
            this.failedAttempts++;
    }

    @Override
    public void lock() {
        if(pin != null) this.isLocked = true;
    }

    @Override
    public boolean isLocked() {
        return this.isLocked;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    @Override
    public void reset() {

    }
}
