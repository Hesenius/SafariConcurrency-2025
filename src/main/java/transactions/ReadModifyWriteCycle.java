package transactions;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;

public class ReadModifyWriteCycle {
//  private static AtomicLong count = new AtomicLong();

  public static void main(String[] args) throws Throwable {
    Runnable incrementer = () -> {
      for (int x = 0; x < 1_000_000_000; x++) {
//        count.incrementAndGet();
      }
      System.out.println("incrementer task on thread " + Thread.currentThread().getName() + " completed");
    };

    long start = System.nanoTime();
    Thread t3 = Thread.ofPlatform().start(incrementer);
    Thread t4 = Thread.ofPlatform().start(incrementer);
    long elapsed = System.nanoTime() - start;
  }
}
