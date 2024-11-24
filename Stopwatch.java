/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */
public class Stopwatch {

    // Private fields to hold the start time, stop time, and running status
    private long startTime;
    private long stopTime;
    private boolean running;

    /**
     * Starts the stopwatch. If the stopwatch is already running,
     * a message is printed to notify the user.
     */
    public void start() {
        if (!running) {
            startTime = System.currentTimeMillis(); // Record the current time in milliseconds
            running = true; // Set the running flag to true
            System.out.println("Stopwatch started.");
        } else {
            System.out.println("Stopwatch is already running.");
        }
    }

    /**
     * Stops the stopwatch. If the stopwatch is not running,
     * a message is printed to notify the user.
     */
    public void stop() {
        if (running) {
            stopTime = System.currentTimeMillis(); // Record the current time as the stop time
            running = false; // Set the running flag to false
            System.out.println("Stopwatch stopped.");
        } else {
            System.out.println("Stopwatch is not running.");
        }
    }

    /**
     * Returns the elapsed time in milliseconds since the stopwatch was started.
     * If the stopwatch is still running, the elapsed time is calculated using the
     * current time. If the stopwatch has been stopped, the elapsed time is calculated
     * using the stop time.
     *
     * @return the elapsed time in milliseconds
     */
    public long getElapsedTime() {
        if (running) {
            // If running, calculate elapsed time using the current time
            return System.currentTimeMillis() - startTime;
        } else {
            // If stopped, calculate elapsed time using the recorded stop time
            return stopTime - startTime;
        }
    }

    /**
     * Resets the stopwatch to its initial state. The start time and stop time are
     * reset to 0, and the running flag is set to false.
     */
    public void reset() {
        startTime = 0; // Reset start time
        stopTime = 0;  // Reset stop time
        running = false; // Reset running flag
        System.out.println("Stopwatch reset.");
    }

    /**
     * Main method to demonstrate the functionality of the Stopwatch class.
     */
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();

        // Start the stopwatch
        stopwatch.start();

        // Simulate a process by making the thread sleep for 2 seconds
        try {
            Thread.sleep(2000); // Sleep for 2000 milliseconds (2 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle any interruption exceptions
        }

        // Stop the stopwatch
        stopwatch.stop();

        // Print the elapsed time in milliseconds
        System.out.println("Elapsed time: " + stopwatch.getElapsedTime() + " milliseconds");

        // Reset the stopwatch
        stopwatch.reset();
    }
}

