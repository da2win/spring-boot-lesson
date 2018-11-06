package com.da2win.springbootlesson17.mbean;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 *
 * MBean 的演示代码
 * @Author Darwin
 * @Date 2018/11/6 10:59
 */
public class MBeanDemo {

    public static void main(String[] args) throws Exception {
        // MBean 服务器 - Agent Level
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        // register MBean
        SimpleData simpleData = new SimpleData();
        // register MBean name
        ObjectName objectName = createObjectName(simpleData);
        mBeanServer.registerMBean(simpleData, objectName);

        // 服务器不马上停止
        Thread.sleep(Long.MAX_VALUE);
    }

    private static ObjectName createObjectName(Object mbean) throws MalformedObjectNameException {
        Class<?> mbeanClass = mbean.getClass();

        String packageName = mbeanClass.getPackage().getName();

        String classSimpleName = mbeanClass.getSimpleName();

        return new ObjectName(packageName + ":type=" + classSimpleName);
    }
}
