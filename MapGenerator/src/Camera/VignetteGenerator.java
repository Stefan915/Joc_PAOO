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
        int ellipseWidth = width - feather;
        int ellipseHeight = height - feather;
        int centerX = width / 2;
        int centerY = height / 2;

        // Create a radial gradient outside the ellipse
        float[] dist = {0.0f, 0.8f, 1.0f};
        Color[] colors = {new Color(0, 0, 0, 0), new Color(0, 0, 0, 150), new Color(0, 0, 0, 255)};

        RadialGradientPaint paint = new RadialGradientPaint(
                centerX, centerY, Math.max(width, height) / 2.0f,
                dist, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE
        );

        g2d.setPaint(paint);
        g2d.fillRect(0, 0, width, height);

        // Clear the ellipse in the center
        g2d.setComposite(AlphaComposite.Clear);
        g2d.fillOval((width - ellipseWidth) / 2, (height - ellipseHeight) / 2, ellipseWidth, ellipseHeight);
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
