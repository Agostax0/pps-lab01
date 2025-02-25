package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {

    private boolean isLocked = false;
    private Integer pin = null;
    public final static int MIN_PIN_ALLOWED = 1000;
    public final static int MAX_PIN_ALLOWED = 9999;
    private int failedAttempts = 0;
    public final static int MAX_FAILED_ATTEMPTS = 10;
    private boolean isBlocked = false;


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

        if(this.failedAttempts >= MAX_FAILED_ATTEMPTS) this.isBlocked = true;
    }

    @Override
    public void lock() {
        if(pin != null) this.isLocked = true; else throw new IllegalArgumentException();
    }

    @Override
    public boolean isLocked() {
        return this.isLocked;
    }

    @Override
    public boolean isBlocked() {
        return this.isBlocked;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_FAILED_ATTEMPTS - this.failedAttempts;
    }

    @Override
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    @Override
    public void reset() {
        this.isLocked = false;
        this.isBlocked = false;
        this.pin = null;
    }
}
