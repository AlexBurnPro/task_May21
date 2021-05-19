package project;

import com.dropbox.core.v2.DbxClientV2;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * отправка файла скриншота на Dropbox
 */

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
            /*
             конвертируем скрин в байтовый поток,
             который будет отправлен в Dropbox
             */

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, "png", os);
            InputStream in = new ByteArrayInputStream(os.toByteArray());

            /*
            форматируем наименование файлов к виду 20210511_200716.png
             */

            Date now = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");

            /*
            отправляем
             */

            client.files().uploadBuilder("/" + formatter.format(now) +".png").uploadAndFinish(in);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
