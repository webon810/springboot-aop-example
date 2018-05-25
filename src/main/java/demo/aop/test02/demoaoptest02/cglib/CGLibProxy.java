package demo.aop.test02.demoaoptest02.cglib;

import demo.aop.test02.demoaoptest02.monitor.MonitorSession;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibProxy implements MethodInterceptor {

    private static CGLibProxy instance = new CGLibProxy();

    private CGLibProxy() {
    }

    public static CGLibProxy getInstance() {
        return instance;
    }

    private Enhancer enhancer = new Enhancer();

    @SuppressWarnings("unchecked")
    public  <T> T getProxy(Class<T> clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2,
                            MethodProxy arg3) throws Throwable {
        MonitorSession.begin(arg1.getName());
        Object obj = arg3.invokeSuper(arg0, arg2);
        MonitorSession.end();
        return obj;
    }
}
