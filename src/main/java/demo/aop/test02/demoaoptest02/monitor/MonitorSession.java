package demo.aop.test02.demoaoptest02.monitor;

import demo.aop.test02.demoaoptest02.monitor.MethodMonitor;

public class MonitorSession {

    private static ThreadLocal<MethodMonitor> monitorThreadLocal = new ThreadLocal<>();

    public static void begin(String method) {
        MethodMonitor logger = new MethodMonitor(method);
        monitorThreadLocal.set(logger);
    }

    public static void end() {
        MethodMonitor logger = monitorThreadLocal.get();
        logger.log();
    }
}
