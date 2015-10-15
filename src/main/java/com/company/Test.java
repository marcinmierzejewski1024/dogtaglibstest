package com.company;

/**
 * Created by marcin on 15.10.15.
 */
public abstract class Test {
    protected String protocol = "http";
    protected String host = "localhost.localdomain";
    protected int port = 8080;
    protected String dbDir = "/home/marcin/.mozilla/firefox/91erqwkz.default";
    protected String nickname = "caadmin";//???
    protected String tokenPassword = "12345678";

    public abstract void init();
    public abstract void test();

}
