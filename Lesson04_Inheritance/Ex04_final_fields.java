package session04_inheritance;

public class Ex04_final_fields extends Thread {

    //1.proberties
    float rate = 0.1F;
    double capital = 100D;
    // 2. run() method

    @Override
    public void run() {
        for (int month = 0; month < 12; month++) {
            capital = capital + (rate * capital);
            String out = String.format("Capital: %1.2f", capital);
            System.out.println(out);
            try {
                Thread.sleep(1500); // gọi đúng class static method
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }

}
