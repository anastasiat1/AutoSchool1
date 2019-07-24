package utils;

import org.testng.IExecutionListener;

public class Listener implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        System.out.println("Start tests");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("Finish tests");
    }
}
