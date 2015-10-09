package com.company;

import com.netscape.certsrv.ca.CAClient;
import com.netscape.certsrv.cert.CertClient;
import com.netscape.certsrv.client.Client;
import com.netscape.certsrv.client.ClientConfig;
import com.netscape.certsrv.client.PKIClient;
import com.netscape.certsrv.profile.ProfileClient;
import com.netscape.certsrv.profile.ProfileDataInfos;
import org.mozilla.jss.CertDatabaseException;
import org.mozilla.jss.CryptoManager;
import org.mozilla.jss.CryptoManager.InitializationValues;
import org.mozilla.jss.KeyDatabaseException;
import org.mozilla.jss.crypto.AlreadyInitializedException;
import org.mozilla.jss.crypto.X509Certificate;

import java.net.URISyntaxException;
import java.security.GeneralSecurityException;

/**
 * Created by SB on 09.10.15.
 */
public class CATest {

    private PKIClient pkiClient;
    private CAClient caClient;
    String protocol = "http";
    String host = "192.168.20.96";
    int port = 8080;;

    private String nickname = "caadmin";//???
    private String pass = "12345678";//????


    public void init() {

        try {

            ClientConfig config = new ClientConfig();
            config.setServerURI(protocol + "://" + host + ":" + port + "/ca");
            config.setCertNickname(nickname);
            config.setCertPassword(pass);

            InitializationValues params = new InitializationValues("/Users/SB/Library/Application\\ Support/Firefox/Profiles/hya34o49.default");
            CryptoManager.initialize(params);



            pkiClient = new PKIClient(config);
            caClient = new CAClient(pkiClient);

            caClient.init();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (KeyDatabaseException e) {
            e.printStackTrace();
        } catch (AlreadyInitializedException e) {
            e.printStackTrace();
        } catch (CertDatabaseException e) {
            e.printStackTrace();
        }
    }


    public void test()
    {
        try {
            X509Certificate[] certs = pkiClient.getCACerts();
            CertClient subClient = (CertClient) caClient.getClient("cert");
            ProfileClient subClient2 = (ProfileClient) caClient.getClient("profile");
            ProfileDataInfos allProfiles = subClient2.listProfiles(0, 100);
            //subClient.listRequests()
            System.out.print("test done"+allProfiles.getEntries());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
