package org.example.pdf;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.util.List;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PdfConvertUtil {

    public static File mergePdfPAgesToSingleImage(File pdfFile, float dpi) throws IOException {

        try (PDDocument document = Loader.loadPDF(pdfFile)) {
            String fileName = pdfFile.getName();
            String outputFileName = fileName.substring(0, fileName.lastIndexOf('.')) + ".jpg";
            File outputImageFile = new File(pdfFile.getParent(), outputFileName);
            int pages = document.getNumberOfPages();
            if (pages == 0) {
                throw new IOException("PDF document is empty.");
            }
            PDFRenderer renderer = new PDFRenderer(document);
            List<BufferedImage> images = new ArrayList<>();
            int totalHeight = 0;
            int maxWidth = 0;

            for (int i = 0; i < pages; i++) {
                BufferedImage pageImage = renderer.renderImageWithDPI(i, dpi);
                images.add(pageImage);
                totalHeight += pageImage.getHeight();
                maxWidth = Math.max(maxWidth, pageImage.getWidth());
            }

            BufferedImage mergedImage = new BufferedImage(maxWidth, totalHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = mergedImage.createGraphics();
            g2d.setPaint(Color.WHITE);
            g2d.fillRect(0, 0, maxWidth, totalHeight);

            int currentY = 0;
            for (BufferedImage image : images) {
                g2d.drawImage(image, 0, currentY, null);
                currentY += image.getHeight();
            }

            g2d.dispose();
            ImageIO.write(mergedImage, "jpg", outputImageFile);
            return outputImageFile;
        }
    }
}
