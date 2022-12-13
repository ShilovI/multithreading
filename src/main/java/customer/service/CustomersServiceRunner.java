package customer.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class CustomersServiceRunner {

    public static void main(String[] args) throws InterruptedException {
        Queue<CustomersSupportSpecialist> customersSupportSpecialists = new ArrayDeque<>();
        customersSupportSpecialists.add(new CustomersSupportSpecialist());
        customersSupportSpecialists.add(new CustomersSupportSpecialist());

        List<CustomerThread> customerThreads = new ArrayList<>();
        customerThreads.add(new CustomerThread(customersSupportSpecialists));
        customerThreads.add(new CustomerThread(customersSupportSpecialists));
        customerThreads.add(new CustomerThread(customersSupportSpecialists));
        customerThreads.add(new CustomerThread(customersSupportSpecialists));
        customerThreads.add(new CustomerThread(customersSupportSpecialists));
        customerThreads.add(new CustomerThread(customersSupportSpecialists));
        customerThreads.add(new CustomerThread(customersSupportSpecialists));
        customerThreads.add(new CustomerThread(customersSupportSpecialists));
        customerThreads.add(new CustomerThread(customersSupportSpecialists));
        customerThreads.add(new CustomerThread(customersSupportSpecialists));
        List<Thread> threads = customerThreads.stream()
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
