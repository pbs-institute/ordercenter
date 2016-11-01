//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package third.crm.util;

import com.drpeng.ordercenter.common.service.ICfgService;
import com.drpeng.ordercenter.common.service.impl.CfgServiceImpl;
import com.drpeng.ordercenter.persistence.entity.CfgExternalApi;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketClient {
    private String host = null;
    private int port = 0;
    private int timeOut = 0;
    private Socket socket = null;
    private InputStream in = null;
    private DataOutputStream dos = null;
    private static ICfgService cfgService = new CfgServiceImpl();



    private SocketClient(String host, int port, int timeOut) {
        this.host = host;
        this.port = port;
        this.timeOut = timeOut;
    }

    public static String send(String key, String content) throws Exception {
        if(content.indexOf("OI_GetRouteSwitch") > 0) {
            key = "AiRoute";
        }

        CfgExternalApi cfgExternalApi = cfgService.findExternalApi(key);

        String host = cfgExternalApi.getIp();
        int port = cfgExternalApi.getPort();
        int timeout = cfgExternalApi.getTimeout();
        SocketClient client = new SocketClient(host, port, timeout);
        return client.sendJson(content);
    }




    private String sendJson(String json) throws Exception {
        byte[] bytes;
        try {
            this.open();
            byte[] reqData = json.getBytes("utf-8");
            int length = reqData.length;
            byte[] reqLen = this.intToByteArray(length, 4, 0);
            byte[] inPack = new byte[length + 4];
            System.arraycopy(reqLen, 0, inPack, 0, 4);
            System.arraycopy(reqData, 0, inPack, 4, length);
            this.send(inPack);
            bytes = this.receive();
        } finally {
            this.close();
        }

        return new String(bytes, "utf-8");
    }

    private void open() throws IOException {
        this.socket = new Socket(this.host, this.port);
        if(this.socket != null) {
            this.socket.setTcpNoDelay(true);
            this.socket.setSoTimeout(this.timeOut);
            this.in = this.socket.getInputStream();
            this.dos = new DataOutputStream(this.socket.getOutputStream());
        }

    }

    private void close() throws IOException {
        if(this.socket != null) {
            this.in.close();
            this.dos.close();
            this.socket.close();
        }

    }

    private void send(byte[] data) throws IOException {
        if(data != null && data.length != 0) {
            this.dos.write(data);
            this.dos.flush();
        } else {
            throw new IOException("[socket_client]指定的数据为空!");
        }
    }

    private byte[] receive() throws Exception {
        byte[] headBuffer = new byte[4];

        int offset;
        int length;
        for(offset = 0; offset < 4; offset += length) {
            length = this.in.read(headBuffer, offset, 4 - offset);
            if(length == -1) {
                throw new IOException("[socket_client]读数据失败，read返回-1");
            }
        }

        length = byteArrayToInt(headBuffer, offset, 0);
        offset = 0;
        byte[] data = new byte[length];

        while(offset < length) {
            int size = this.in.read(data, offset, length - offset);
            if(size > 0) {
                offset += size;
            }
        }

        return data;
    }

    private static int byteArrayToInt(byte[] data, int length, int alignment) throws Exception {
        int value = 0;
        int i;
        switch(alignment) {
        case 0:
            for(i = 0; i < length; ++i) {
                value <<= 8;
                value += toInt(data[i]);
            }

            return value;
        case 1:
            for(i = 0; i < length; ++i) {
                value <<= 8;
                value += toInt(data[length - i - 1]);
            }

            return value;
        default:
            throw new Exception("[socket_client]数据对齐方式非法!");
        }
    }

    private static int toInt(byte b) {
        return b >= 0?b:b + 256;
    }

    private byte[] intToByteArray(int value, int length, int alignment) throws Exception {
        byte[] data = new byte[length];
        int i;
        switch(alignment) {
        case 0:
            for(i = 0; i < length; ++i) {
                data[length - i - 1] = (byte)(value & 255);
                value >>>= 8;
            }

            return data;
        case 1:
            for(i = 0; i < length; ++i) {
                data[i] = (byte)(value & 255);
                value >>>= 8;
            }

            return data;
        default:
            throw new Exception("[socket_client]数据对齐方式非法!");
        }
    }
}
