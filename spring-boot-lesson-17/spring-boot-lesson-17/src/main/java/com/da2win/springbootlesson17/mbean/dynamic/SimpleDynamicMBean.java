package com.da2win.springbootlesson17.mbean.dynamic;

import javax.management.*;

/**
 * {@link DynamicMBean} 简单实现
 * <p>
 * 动态定义 Bean 接口
 * 定义一个名为"value" 属性
 * 定义一个名为的 "displayValue" 的操作
 *
 * @Author Darwin
 * @Date 2018/11/6 15:04
 */
public class SimpleDynamicMBean implements DynamicMBean {
    private String value;

    @Override
    public Object getAttribute(String attribute) throws AttributeNotFoundException, MBeanException, ReflectionException {
        return value;
    }

    @Override
    public void setAttribute(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        String attributeName = attribute.getName();
        if ("value".equals(attributeName)) {
            this.value = (String) attribute.getValue();
        }
    }

    @Override
    public AttributeList getAttributes(String[] attributes) {
        return null;
    }

    @Override
    public AttributeList setAttributes(AttributeList attributes) {
        return null;
    }

    @Override
    public Object invoke(String actionName, Object[] params, String[] signature) throws MBeanException, ReflectionException {
        if ("displayValue".equals(actionName)) { // 类似于 AOP 的操作
            return value;
        }
        return null;
    }

    @Override
    public MBeanInfo getMBeanInfo() {
        MBeanInfo mBeanInfo = new MBeanInfo(this.getClass().getName(), "简单的自定义DynamicMBean",
                of(new MBeanAttributeInfo("value", String.class.getName(), "动态属性value", true, true, false)),
                of(new MBeanConstructorInfo(this.getClass().getSimpleName(), "默认构造器", new MBeanParameterInfo[0])),
                of(new MBeanOperationInfo("displayValue", "自定义 displayValue 方法", new MBeanParameterInfo[0], String.class.getName(), MBeanOperationInfo.ACTION)),
                new MBeanNotificationInfo[0]
                );
        return mBeanInfo;
    }

    private static <T> T[] of(T... array) {
        return array;
    }

}
