package com.alibaba.java.SpringDemo;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Properties;

/**
 * 假设现在在项目中不引入spring框架，我们来自己手写一个面向切面的事务管理机制。
 * 事务管理应该放在service，dao层只负责数据库的增删改查，假设我们现在有一系列service代码
 * （如UserService,CustomerService,MoneyService）,要是在每一个service单独实现事务管理，
 * 显然过于复杂，不符合编程中代码复用的思想。那么我们可以把这些重复的事务管理操作抽取到一个工厂类中，
 * 工厂负责生产Service,并根据是否有注解，区分这个Service是否要进行事务处理。我们可以用动态代理技术对Service进行代理，
 * 对需要进行事务处理的Service的方法进行增强。最终实现Service层的事务自动管理。
 */
public class SpringTransactionDemo {
    @Autowired
    private ApplicationContext applicationContext;
    public <T extends Service> T getService(Class<T> clazz) throws FileNotFoundException {//把所有子类的泛型限制在Service子类中
        //把所有的Service都写在配置文件中，根据配置文件创建具体的Service实例
        try {
        Properties properties = new Properties();
        String url = null;//假设url是配置资源的properties 路径
        InputStream inputStream = new BufferedInputStream(new FileInputStream(new File(url)));
        String infName = clazz.getSimpleName();
        String implName= properties.getProperty(infName);
            String[] beanNames = applicationContext.getBeanNamesForType(Object.class);
            for (String name:beanNames
                 ) {
                Tran tran = applicationContext.findAnnotationOnBean(name,Tran.class);
            }
            final T service = (T)Class.forName(implName).newInstance();
            //简单总结一下 上面所有的过程实例化 clazz
            //动态代理生成代理之后的Service，实现事务管理的自动化
            //--为了实现Aop，生成Service代理，根据注解确定在Service方法执行之前和之后做一些操作
            //比如事务管理、记录日志、细粒度的权限控制
            T proxyService = (T)Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            if(method.isAnnotationPresent(Tran.class)){

                            }return null;

                        }
                    });

            return proxyService ;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  null;
    }

}
