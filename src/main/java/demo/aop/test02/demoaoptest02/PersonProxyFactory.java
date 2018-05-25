package demo.aop.test02.demoaoptest02;

import demo.aop.test02.demoaoptest02.cglib.CGLibProxy;
import demo.aop.test02.demoaoptest02.jdkproxy.DynamicProxy;
import demo.aop.test02.demoaoptest02.service.Person;
import demo.aop.test02.demoaoptest02.service.PersonImpl;
import demo.aop.test02.demoaoptest02.service.Speakable;

public class PersonProxyFactory {

    public static Speakable newJdkProxy() {
        DynamicProxy dynamicProxy = new DynamicProxy(new PersonImpl());
        Speakable proxy = dynamicProxy.getProxy();
        return proxy;
    }

    public static Person newCglibProxy() {
        CGLibProxy cglibProxy = CGLibProxy.getInstance();
        Person proxy = cglibProxy.getProxy(Person.class);
        return proxy;
    }
}
