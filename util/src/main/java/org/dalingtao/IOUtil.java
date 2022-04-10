package org.dalingtao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class IOUtil {
    public static String readAll(InputStream is, Charset charset) throws IOException {
        byte[] data = new byte[1 << 13];
        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        int len;
        while ((len = is.read(data)) != -1) {
            bis.write(data, 0, len);
        }
        return bis.toString(charset);
    }

    public static String readAll(File file, Charset charset) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            return readAll(fis, charset);
        }
    }

    public static String readAll(File file) throws IOException {
        return readAll(file, StandardCharsets.UTF_8);
    }

    public static String readAll(String file) throws IOException {
        return readAll(new File(file));
    }

    public static String readAll(String file, Charset charset) throws IOException {
        return readAll(new File(file), charset);
    }

    public static void writeAll(OutputStream os, byte[] data) throws IOException {
        os.write(data);
    }

    public static void writeAll(File file, byte[] data) throws IOException {
        try (var os = new FileOutputStream(file)) {
            writeAll(os, data);
        }
    }

    public static void writeAll(String file, byte[] data) throws IOException {
        writeAll(new File(file), data);
    }
}
