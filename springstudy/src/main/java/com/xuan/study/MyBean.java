package com.xuan.study;

import org.springframework.stereotype.Component;

/**
 * @author xuan
 */
@Component
public class MyBean {

    private String name;
    private MyPropertyBean myPropertyBean;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public MyPropertyBean getMyPropertyBean() {
        return myPropertyBean;
    }

    public void setMyPropertyBean(MyPropertyBean myPropertyBean) {
        this.myPropertyBean = myPropertyBean;
    }
}
