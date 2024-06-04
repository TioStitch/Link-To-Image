import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    private static final String LINK_FROM_IMAGE = "https://claudia.abril.com.br/wp-content/uploads/2020/01/thais-carla-1-1.jpg?crop=1&resize=1212,909";

    public static void main(String[] args) {

        try {
            URL url = new URL(LINK_FROM_IMAGE);

            InputStream inputStream = url.openStream();
            OutputStream outputStream = new FileOutputStream("image.png");

            byte[] byteBuffer = new byte[4096];
            int n;

            while ((n = inputStream.read(byteBuffer)) > 0) {
                outputStream.write(byteBuffer, 0, n);
            }


        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}