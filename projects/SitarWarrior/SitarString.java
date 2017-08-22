/* Name: Susan Zhao
 * Pennkey: suzhao
 * Recitation: 216
 * 
 * Execution: creates each sitar string of a given frequency
 * 
 */

public class SitarString {

    private RingBuffer buffer; // ring buffer
    private int numTics;
    private int numSamples;
    private static final double HERTZ = 44100;
    private static final double ENERGY_DECAY_FACTOR = -0.997;

    /* Description: creates a sitar string of the given frequency
     * Input: double value of the frequency
     * Output: none
     */
    public SitarString(double frequency) {
        numSamples = (int) Math.ceil(HERTZ / frequency);
        buffer = new RingBuffer(numSamples);
        for (int i = 0; i < numSamples; i++) {
            buffer.enqueue(0.0);
        }
    }

    /* Description: plucks the sitar string by replacing the buffer with white
     * noise
     * Input: none
     * Output: none
     */
    public void pluck() {
        for (int i = 0; i < numSamples; i++) {
            buffer.dequeue();
            buffer.enqueue(Math.random() - 0.5);
        }
    }

    /* Description: advances the simulation one time step
     * Input: none
     * Output: void/none
     */
    public void tic() {
        numTics++;
        double x = sample();
        buffer.dequeue();
        double y = sample();
        buffer.enqueue(((x + y) / 2) * ENERGY_DECAY_FACTOR);
    }

    /* Description: returns the current sample
     * Input: none
     * Output: double value of the sample
     */
    public double sample() {
        return buffer.peek();
    }

    /* Description: returns the number of times tic was called
     * Input: none
     * Output: integer value of the number of times tic was called
     */
    public int time() {
        return numTics;
    }

    public static void main(String[] args) {
        // how many samples should we "play"
        int numSamplesToPlay = Integer.parseInt(args[0]);

        // a starting set of samples; it's pretty easy to calculate
        // the new samples that will get generated with a calculator
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };

        // create a sitar string to test with exactly samples.length,
        // this looks a little funny because the SitarString constructor
        // expects a frequency, not a number of elements
        SitarString testString = new SitarString(44100.0 / samples.length);

        // at this point the RingBuffer underlying testString should have
        // a capacity of samples.length and should be full
        System.out.println("testString.buffer.isEmpty(): " +
                            testString.buffer.isEmpty());
        System.out.println("testString.buffer.isFull():  " +
                            testString.buffer.isFull());

        // replace all the zeroes with the starting samples
        for (int i = 0; i < samples.length; i++) {
            testString.buffer.dequeue();
            testString.buffer.enqueue(samples[i]);
        }

        // "play" for numSamples samples; printing each one for inspection
        for (int i = 0; i < numSamplesToPlay; i++) {
            int t = testString.time();
            double sample = testString.sample();

            // this statement prints the time t, padded to 6 digits wide
            // and the value of sample padded to a total of 8 characters
            // including the decimal point and any - sign, and rounded
            // to four decimal places
            System.out.printf("%6d %8.4f\n", t, sample);

            testString.tic(); // advance to next sample
        }
    }
}