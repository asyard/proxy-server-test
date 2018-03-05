package core;

import java.io.Serializable;

/**
 * Created by Asil on 5.03.2018.
 */
public class ReqMsg implements Serializable {

    private long id = 1L;

    private byte[] cert;

    public ReqMsg() {
    }

    public byte[] getCert() {
        return cert;
    }

    public void setCert(byte[] cert) {
        this.cert = cert;
    }
}
