package core;

import java.util.List;

/**
 * Created by Asil on 5.03.2018.
 */
public class RespMsg {

    private List<byte[]> sctList;

    public RespMsg() {
    }

    public List<byte[]> getSctList() {
        return sctList;
    }

    public void setSctList(List<byte[]> sctList) {
        this.sctList = sctList;
    }
}
