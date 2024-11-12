package ParkProject;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.awt.image.BufferedImage;

public class QRCodeGenerator {
    public static BufferedImage generateQRCodeImage(String text) throws WriterException {
        int width = 200;  // Width of the QR code
        int height = 200; // Height of the QR code

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        // Convert BitMatrix to BufferedImage
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}

