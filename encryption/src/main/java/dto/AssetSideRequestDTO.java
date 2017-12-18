package dto;

import java.io.Serializable;

/**
 * Created by chenjianshuo on 2017/11/1 17:15.
 */
public class AssetSideRequestDTO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private T data;

    private String key;

    private String tdUserName;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTdUserName() {
        return tdUserName;
    }

    public void setTdUserName(String tdUserName) {
        this.tdUserName = tdUserName;
    }

    @Override
    public String toString() {
        return "dto.AssetSideRequestDTO{" +
                "data='" + data + '\'' +
                ", key='" + key + '\'' +
                ", tdUserName='" + tdUserName + '\'' +
                '}';
    }
}
