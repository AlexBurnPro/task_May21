package project;

import com.dropbox.core.v2.DbxClientV2;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Uploader extends Thread{
    private DbxClientV2 client;
    private BufferedImage image;

    public Uploader(DbxClientV2 client, BufferedImage image) {
        this.client = client;
        this.image = image;
    }

    @Override
    public void run() {
        try {
            //TODO: convert BufferedImage to InputStream
            //  using ByteArrayInputStream and
            //  ByteArrayOutputStream
            InputStream in = null;
            //TODO: change "/picture.png" to current
            //  date, time and png-extension:
            //  20210511_200716.png
            client.files().uploadBuilder("/picture.png")
                    .uploadAndFinish(in);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
