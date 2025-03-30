package Camera;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class VignetteGenerator {
    public static void createVignette(String filename, int width, int height, int feather) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Enable anti-aliasing for smoother gradients
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        // Fill with transparent background
        g2d.setComposite(AlphaComposite.Clear);
        g2d.fillRect(0, 0, width, height);
        g2d.setComposite(AlphaComposite.SrcOver);

        // Define ellipse dimensions
        int ellipseWidth = width - feather * 2;
        int ellipseHeight = height - feather * 2;
        int centerX = width / 2;
        int centerY = height / 2;

        // Create a radial gradient outside the ellipse
        BufferedImage vignette = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gVignette = vignette.createGraphics();
        gVignette.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double dx = (double)(x - centerX) / (ellipseWidth / 2.0);
                double dy = (double)(y - centerY) / (ellipseHeight / 2.0);
                double distance = Math.sqrt(dx * dx + dy * dy);

                int alpha = (int)(Math.max(0, Math.min(255, (distance - 1) * 255 / (feather / 100.0))));
                Color color = new Color(0, 0, 0, alpha);
                vignette.setRGB(x, y, color.getRGB());
            }
        }

        g2d.drawImage(vignette, 0, 0, null);
        g2d.dispose();

        try {
            ImageIO.write(image, "png", new File(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createVignette("vignette.png", 500, 500, 100);
    }
}
