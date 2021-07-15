package com.example.exampleproject.qr;

import com.example.exampleproject.util.QRUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class QrCodeEx {

    public static void main(String[] args) {
        QRUtil qrUtil = new QRUtil();
//        qrUtil.makeQR("https://www.naver.com/",50,50,"D:" + File.separator + "qr_img" + File.separator, "qrEx");
        qrUtil.makeQR("https://earth.google.com/web/search/%ED%94%84%EB%9E%91%EC%8A%A4+%ED%8C%8C%EB%A6%AC+%ED%9E%88%EB%B3%BC%EB%A6%AC+%EA%B0%80+%EB%A3%A8%EB%B8%8C%EB%A5%B4+%EB%B0%95%EB%AC%BC%EA%B4%80/@48.8613129,2.3345799,36.46448749a,0d,60y,109.66143033h,97.44892353t,0r/data=Cp0BGnMSbQolMHg0N2U2NzFkODc3OTM3YjBmOjB4Yjk3NWZjZmExOTJmODRkNBmMiSiBKG5IQCFmho2yfrMCQCoy7ZSE656R7IqkIO2MjOumrCDtnojrs7zrpqwg6rCAIOujqOu4jOultCDrsJXrrLzqtIAYASABIiYKJAm-lTIXUHA1QBG5lTIXUHA1wBkwN748y740wCGrynhmGhBfwCIwCixBRjFRaXBQQmt1TlRLT1JFLVJ6czE5b0dfUHViZUVPSFZwVHZaUHhROXhJMhAF",300,300,"D:" + File.separator + "qr_img" + File.separator, "qrEx1");

    }
}
