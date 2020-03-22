package GUIs;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageInFrame extends JFrame{

    private JLabel QR;
    private JTextArea texto;


    /**
     * @param ruta String indica la ruta en la que se encuentra el archivo del codigo QR.
     * @param textoQR String que posee el texto del codigo QR.
     * @throws IOException Excepcion que ocurre al suceder un error orientado a Archivos.
     */
    public void mostrarQR(String ruta, String textoQR) throws IOException {

            Dimension dim = getPreferredSize();
            dim.width = 300;
            dim.height = 400;
            setPreferredSize(dim);

            String path = ruta;
            File file = new File(path);

            BufferedImage image = ImageIO.read(file);
            QR = new JLabel(new ImageIcon(image));
            setSize(800, 1000);

            texto = new JTextArea(textoQR);
            texto.setSize(300, 110);

            QR.setSize(getPreferredSize());

            getContentPane().add(texto);
            getContentPane().add(QR);
            pack();
            setLocation(200, 200);
            setVisible(true);
    }
}
