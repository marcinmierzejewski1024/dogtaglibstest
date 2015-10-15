package com.company;

import com.netscape.certsrv.account.AccountClient;
import com.netscape.certsrv.client.ClientConfig;
import com.netscape.certsrv.client.PKIConnection;
import com.netscape.certsrv.system.SecurityDomainClient;

import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) {
        //CATest test = new CATest();
        //test.init();
        //test.test();

        DRMTest test2 = new DRMTest();
        test2.init();
        test2.test();


    }
}
