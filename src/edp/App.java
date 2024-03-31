package edp;

import org.junit.runner.JUnitCore;
public class App {
    public static void main(String[] args) throws Exception {
        Dic dic = new Dic();

        
        String[] testClasses = {"TestApp"}; 
        JUnitCore.main(testClasses);
    }
}