import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class LinkToImage {

    private final Scanner scanner = new Scanner(System.in);
    private final String ARCHIVE_NAME = "resulted_image.png";

    private LinkToImage() {

        System.out.println("[Link to Image] Insira o (LINK) da imagem a ser convertida para png:");
        final String LINK = scanner.nextLine();

        System.out.println("[Link to Image] Link da imagem: " + LINK);

        if (!isConverted(LINK)) {
            System.out.println("[Link to Image] Ocorreu um erro ao converter o seu link!");
        }

        System.out.println("[Link to Image] Imagem obtida com sucesso!");
    }

    private boolean isConverted(String LINK) {
        try {
            final URL url = new URL(LINK);

            try (final BufferedInputStream bufferInput = new BufferedInputStream(url.openStream())) {
                final BufferedOutputStream bufferOutput = new BufferedOutputStream(Files.newOutputStream(Paths.get(ARCHIVE_NAME)));

                byte[] buffers = new byte[4096];
                int maxBufferSize;

                while ((maxBufferSize = bufferInput.read(buffers)) > 0) {
                    bufferOutput.write(buffers, 0, maxBufferSize);
                }

                return true;
            } catch (IOException e) {
                System.out.println("[Link to Image] Ocorreu um erro ao ler o 'inputStream'!");
                return false;
            }
        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        new LinkToImage();
    }
}
