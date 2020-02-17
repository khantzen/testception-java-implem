package fr.noether.testception;

import java.util.function.Consumer;

public class TestCaseTest extends TestCase {
    public TestCaseTest(Consumer<TestCaseTest> testMethod) {
        super(testMethod);
    }

    public void testTemplate() {
        var myTest = new WasRun(WasRun::testTemplate);
        myTest.run();
        assert myTest.log().equals("setUp wasRun tearDown");
    }

    public void testSuccessResult() {
        var myTest = new WasRun(WasRun::testSuccess);
        var result = myTest.run();
        assert result.summary().equals("1 run, 0 fail");
    }

    public void testFailureResult() {
        var myTest = new WasRun(WasRun::testFailure);
        var result = myTest.run();
        assert result.summary().equals("1 run, 1 fail");
    }

    public void testSuite() {
        var suite = new TestSuite();

        suite.add(new WasRun(WasRun::testSuccess));
        suite.add(new WasRun(WasRun::testSuccess));
        suite.add(new WasRun(WasRun::testSuccess));
        suite.add(new WasRun(WasRun::testFailure));

        var result = suite.run();

        assert result.summary().equals("4 run, 1 fail");
    }
}
