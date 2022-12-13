package deadlock;

public class Account {

    private static int idSeq = 1;

    private final int id;
    private int amount;

    public Account(int amount) {
        this.amount = amount;
        id = idSeq++;
    }

    public void add(int amount) {
        this.amount += amount;
    }

    public boolean takeOff(int amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
            return true;
        } else {
            return false;
        }
    }
}
