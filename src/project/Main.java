package project;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {

    public static void main (String[] args) throws AWTException {

        //TODO: download Dropbox library and
        //  generate token to access it
        String ACCESS_TOKEN = "*****************************************";

        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        for(;;) {
            //TODO: get screenshot
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

//        //TODO: 20210510_204601
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
//        Date now = new Date();
//        System.out.println(formatter.format(now));
//
//        //TODO: get screenshot
//        BufferedImage image =
//            new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
//        System.out.println(image.getWidth() + "x" + image.getHeight());
//
//        //TODO: send code and console screenshots
//        //  to Telegram-chat with tag #ilovejava
    }
}
