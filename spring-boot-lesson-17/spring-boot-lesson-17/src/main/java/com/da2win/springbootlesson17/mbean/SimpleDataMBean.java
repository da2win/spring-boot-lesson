package com.da2win.springbootlesson17.mbean;

/**
 * @Author Darwin
 * @Date 2018/11/6 10:56
 */
public interface SimpleDataMBean {

    /**
     * Setter
     * Property
     * @param data
     */
    void setData(String data);


    /**
     * Getter
     * Property
     * @return
     */
    String getData();

    /**
     *  Operation
      * @return
     */
    String displayData();
}
