package customer.service;

import java.util.Queue;

public class CustomerThread implements Runnable {

    private final Queue<CustomersSupportSpecialist> supportSpecialists;

    public CustomerThread(Queue<CustomersSupportSpecialist> supportSpecialists) {
        this.supportSpecialists = supportSpecialists;
    }

    @Override
    public void run() {
        try {
            synchronized (supportSpecialists) {
                while (true) {
                    if (!supportSpecialists.isEmpty()) {
                        CustomersSupportSpecialist specialist = supportSpecialists.remove();
                        System.out.printf("%s work with customer %s%n", specialist.getId(),
                                Thread.currentThread().getName());
                        supportSpecialists.wait(5L);
                        System.out.printf("%s have finished work with customer %s%n", specialist.getId(),
                                Thread.currentThread().getName());
                        supportSpecialists.add(specialist);
                        supportSpecialists.notifyAll();
                        break;
                    } else {
                        System.out.printf("%s his waiting for free specialist%n", Thread.currentThread().getName());
                        supportSpecialists.wait();
                    }
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
