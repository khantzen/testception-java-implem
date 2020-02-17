package fr.noether.testception;

public class TestResult {
    private int launch;
    private int fail;

    public TestResult(int launch, int fail) {
        this.launch = launch;
        this.fail = fail;
    }

    public static TestResult empty() {
        return new TestResult(0, 0);
    }

    public String summary() {
        return String.format("%s run, %s fail", launch, fail);
    }

    public void launch() {
        this.launch += 1;
    }

    public void fail() {
        this.fail += 1;
    }

    public static TestResult merge(TestResult acc, TestResult next) {
        return new TestResult(acc.launch + next.launch, acc.fail + next.fail);
    }
}
