package project;

import com.dropbox.core.v2.DbxClientV2;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

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

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, "png", os);
            InputStream in = new ByteArrayInputStream(os.toByteArray());

            //TODO: change "/picture.png" to current
            //  date, time and png-extension:
            //  20210511_200716.png

            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Date now = new Date();
            client.files().uploadBuilder("/" + formatter.format(now) +".png").uploadAndFinish(in);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
