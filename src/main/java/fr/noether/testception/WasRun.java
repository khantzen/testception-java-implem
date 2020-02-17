package fr.noether.testception;

import java.util.function.Consumer;

public class WasRun extends TestCase {
    private String log;

    public WasRun(Consumer<WasRun> testMethod) {
        super(testMethod);
        this.log = "";
    }

    @Override
    public void setUp() {
        this.log += "setUp";
    }

    public void testTemplate() {
        this.log += " wasRun";
    }

    @Override
    public void tearDown() {
        this.log += " tearDown";
    }

    public String log() {
        return this.log;
    }

    public void testSuccess() {
        assert true;
    }

    public void testFailure() {
        assert false;
    }
}
