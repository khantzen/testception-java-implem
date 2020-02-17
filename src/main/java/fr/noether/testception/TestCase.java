package fr.noether.testception;

import java.util.function.Consumer;

public class TestCase {
    protected Consumer testMethod;

    public TestCase(Consumer<? extends TestCase> testMethod) {
        this.testMethod = testMethod;
    }

    public TestResult run() {
        var result = new TestResult(0, 0);

        try {
            result.launch();

            this.setUp();
            this.testMethod.accept(this);
            this.tearDown();

        } catch (AssertionError ignored) {
            result.fail();
        }

        return result;
    }

    public void setUp() {
    }

    public void tearDown() {
    }
}
