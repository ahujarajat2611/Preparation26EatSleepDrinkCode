package SystemDesign;

import java.util.Calendar;
import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Scheduler {
    /**
     * Interface that defines a task to be run by this scheduler.
     */
    public interface Task {
        /**
         * Run the task.
         */
        void run();
    }

    private static final int CAPACITY = 10;

    private final BlockingQueue<TimedTask> queue = new PriorityBlockingQueue<>(CAPACITY,
            new Comparator<TimedTask>() {
                @Override
                public int compare(TimedTask s, TimedTask t) {
                    return s.getScheduledTime().compareTo(t.getScheduledTime());
                }
            });

    private final Object lock = new Object();
    private volatile boolean running = true;

    public void start() throws InterruptedException {
        while (running) {
            TimedTask task = queue.take();
            if (task != null) {
                task.run(); // Ideally this should be run in a separate thread.
            }
            waitForNextTask();
        }
    }

    private void waitForNextTask() throws InterruptedException {
        synchronized (lock) {
            TimedTask nextTask = queue.peek();
            while (nextTask == null || !nextTask.shouldRunNow()) {
                if (nextTask == null) {
                    lock.wait();
                } else {
                    lock.wait(nextTask.runFromNow());
                }
                nextTask = queue.peek();
            }
        }
    }

    public void add(Task task) {
        add(task, 0);
    }

    public void add(Task task, long delayMs) {
        synchronized (lock) {
            queue.offer(TimedTask.fromTask(task, delayMs));
            lock.notify();
        }
    }

    public void stop() {
        this.running = false;
    }

    private static class TimedTask {
        private Task task;
        private Calendar scheduledTime;

        public TimedTask(Task task, Calendar scheduledTime) {
            this.task = task;
            this.scheduledTime = scheduledTime;
        }

        public static TimedTask fromTask(Task task, long delayMs) {
            Calendar now = Calendar.getInstance();
            now.setTimeInMillis(now.getTimeInMillis() + delayMs);
            return new TimedTask(task, now);
        }

        public Calendar getScheduledTime() {
            return scheduledTime;
        }

        public long runFromNow() {
            return scheduledTime.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();
        }

        public boolean shouldRunNow() {
            return runFromNow() <= 0;
        }

        public void run() {
            task.run();
        }
    }

    public static void main(String[] argv) throws InterruptedException {
        class MyTask implements Task {
            private String name;

            public MyTask(String name) {
                this.name = name;
            }

            @Override
            public void run() {
                System.out.println(name + ": " + Calendar.getInstance().getTimeInMillis());
            }
        }

        final Scheduler scheduler =  new Scheduler();
        scheduler.add(new MyTask("No. 1"));
        scheduler.add(new MyTask("No. 2"), 10000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    scheduler.start();
                } catch (InterruptedException e) {

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                scheduler.add(new MyTask("No. 3"), 200);
                scheduler.add(new MyTask("No. 4"), 1000);
                scheduler.add(new MyTask("No. 5"), 300);
                scheduler.add(new MyTask("No. 6"), 700);
                scheduler.add(new MyTask("No. 7"), 100);
            }
        }).start();
    }
}