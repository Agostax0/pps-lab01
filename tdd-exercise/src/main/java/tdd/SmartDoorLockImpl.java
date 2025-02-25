package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {

    private boolean locked = false;
    private Integer pin = null;
    public final static int MIN_PIN_ALLOWED = 1000;
    public final static int MAX_PIN_ALLOWED = 9999;
    private int failedAttempts = 0;
    public final static int MAX_FAILED_ATTEMPTS = 10;
    private boolean blocked = false;


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
            this.locked = false;
        else
            this.failedAttempts++;

        if(this.failedAttempts >= MAX_FAILED_ATTEMPTS) this.blocked = true;
    }

    @Override
    public void lock() {
        if(pin != null) this.locked = true; else throw new IllegalArgumentException();
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean isBlocked() {
        return this.blocked;
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
        this.locked = false;
        this.blocked = false;
        this.pin = null;
    }
}
