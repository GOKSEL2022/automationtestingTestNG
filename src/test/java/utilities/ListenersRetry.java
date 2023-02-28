package utilities;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class ListenersRetry implements IRetryAnalyzer {
    //    BU SINIF SADECE FAIL OLAN TEST CASELERE TEKRAR CALISTIRIR
    private int retryCount = 0;
    //    maxRetryCount EK OLARAK CALISMA SAYISI. BU ORNEKDE FAIL OLNA TESTLER EXTRA 1 KEZ DAHA CALISIR
    private static final int maxRetryCount = 1;
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}