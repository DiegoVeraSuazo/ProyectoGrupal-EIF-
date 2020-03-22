package archivo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


/**
 *
 */
public class Zxing {


    /**
     * @param texto String que posee el texto que se convertira a un codigo QR.
     * @param ruta  String que posee la direccion que va tener el codigo QR.
     * @throws WriterException Clase base que cubre el rango de excepciones que pueden ocurrir al codificar un codigo de barra usando el Writer Framework.
     * @return boolean que indica si se genero el codigo QR.
     */
    public static boolean generateQR(String texto, String ruta) throws WriterException {
        try {
            String qrCodeText = texto;
            String filePath = ruta;
            int size = 125;
            String fileType = "png";
            File qrFile = new File(filePath);
            createQRImage(qrFile, qrCodeText, size, fileType);
            System.out.println("DONE");
            return true;
        } catch (IOException e) {
            System.out.println("Ingreso de datos erroneo");
            return false;
        }
    }


    /**
     * @param qrFile File indica el nombre con el que se nombrara el Codigo QR.
     * @param qrCodeText String que guarda el texto que se convertira a codigo QR.
     * @param size int que indica el tamaño del codigo QR.
     * @param fileType String que indica el tipo de archivo al que se convertira el codigo QR.
     * @throws WriterException Clase base que cubre el rango de excepciones que pueden ocurrir al codificar un codigo de barra usando el Writer Framework.
     * @throws IOException Excepcion que ocurre al suceder un error orientado a Archivos.
     */
    private static void createQRImage(File qrFile, String qrCodeText, int size, String fileType)
            throws WriterException, IOException {
        // Create the ByteMatrix for the QR-Code that encodes the given String
        Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
        // Make the BufferedImage that are to hold the QRCode
        int matrixWidth = byteMatrix.getWidth();
        BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
        image.createGraphics();

        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, matrixWidth, matrixWidth);
        // Paint and save the image using the ByteMatrix
        graphics.setColor(Color.BLACK);

        for (int i = 0; i < matrixWidth; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                if (byteMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }
        ImageIO.write(image, fileType, qrFile);
    }



}
