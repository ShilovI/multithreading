package customer.service;

public class CustomersSupportSpecialist {

    private static int idSeq = 1;
    private final int id;

    public CustomersSupportSpecialist() {
        this.id = idSeq++;
    }

    public int getId() {
        return id;
    }
}
