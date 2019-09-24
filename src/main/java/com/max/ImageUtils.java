package com.max;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class ImageUtils {

    public static String getBase64(InputStream fileContent) {
        String resut = null;
        if (fileContent == null) {
            return resut;
        }
        try {
            byte[] qwe = getBytesFromInputStream(fileContent);
            resut = Base64.getEncoder().encodeToString(qwe);
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
        return resut;
    }

    private static byte[] getBytesFromInputStream(InputStream is) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[16384];
        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        return buffer.toByteArray();
    }
}
