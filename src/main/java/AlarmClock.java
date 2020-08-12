import com.sun.security.ntlm.Client;

import java.time.Clock;



public class Monitor {
    private int now;
    private MyLinkedList waitList;
    private int max;

    // no additional synchronization used

    /**
     * Class constructor
     * Creates an empty list that will keep specific notification locks.
     * Each notification lock will have a key field called time, which will
     * be equal to the wakeup time of the thread.
     */
    Monitor(int maxTime) {
        now = 0;
        waitList = new MyLinkedList();
        max = maxTime;
    }

    /**
     * Increments the time by one.
     * If the list of notification locks is not empty and the head of the
     * list needs to be awaken, removes the head of the
     * list and notifies everyone sleeping on that lock.
     */
    void tick() {
		synchronized (this) {
        now++;

        if (!waitList.isEmpty()) {
            MyObject first = (MyObject) waitList.firstElement();

            if (first.time() == now) {
                MyObject wakeup = first;
                waitList.removeElementAt(0);

                synchronized (wakeup) {
                    wakeup.notifyAll();
                }
            }
        }
		}
    }

    void wakeme(int id, int interval) {
        int waketime;
        MyObject lock;

        /**
         * First part of this method calculates the waketime and creates
         * a specific notification lock
         */
        synchronized (this) {
            waketime = now + interval;

            if (waketime > max) {
                return;
            }

            lock = waitList.createLock(waketime);
        }

        /**
         * Second part of the wakeme(int,int) method.
         * Synchronized on the specific notification lock with the key that's equal
         * waketime.
         * Puts a thread to sleep on the specific lock.
         * Since while a thread is trying to go to sleep on the specific lock,
         * it's possible for a Clock thread to enter the monitor at this time and
         * wake up the head of the list. If the thread wanted to sleep on the head
         * of the list or close to the head
         * of the list, it's possible to be late. If a thread wants to sleep on the lock
         * that's been awakened already that it doesn't need to sleep at all.
         * This thread's waketime has expired. For this case
         * try{}catch clause is used.
         * If a thread wants to sleep on the lock that's been removed already
         * IndexOutOfBounds Exception is caught and the thread that is late is
         * considered awaken.
         */
        try {
            synchronized (waitList.getLock(waketime)) {
                try {
                    waitList.getLock(waketime).wait();
                } catch (InterruptedException e) {
                }
            }
        } catch (IndexOutOfBoundsException e) {
        }
    }

    /**
     * Gets the current time of the clock.
     */
    int getTime() {
        return now;
    }
}

