package co.com.nifi.tasks;

import static co.com.nifi.tasks.GetStatusApi.getStatusNifi;
import static co.com.nifi.utils.Constants.*;

public class ExecutionCyclesApis {

    public static boolean waitNifiComplete() {
        int retries = RETRIES_NUMBER;
        while (retries > 0) {
            String nifiStatus = getStatusNifi();
            if (STATUS_NIFI_STOP.equals(nifiStatus)) {
                System.out.println("Proceso terminado....");
                return false;
            }
            try {
                Thread.sleep(WAIT_TIME);
                System.out.println("Proceso ejecutandose....");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
            retries--;
        }
        return true;
    }
}
