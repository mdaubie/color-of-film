package io.github.mdaubie.coloroffilm.shapers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class ImageShaper {
    protected BufferedImage image;
    protected Graphics g;
    protected final String suffix;
    protected int resolution;

    protected ImageShaper(String suffix) {
        this.suffix = suffix;
    }

    protected abstract BufferedImage getImage(int resolution);

    public void build(int resolution) {
        this.resolution = resolution;
        image = getImage(resolution);
        g = image.getGraphics();
    }

    public abstract void paintChunk(Color color, int chunkIdx, int chunkNumber);

    public void saveImage(String outputDir, String title, boolean openFileOnSave) throws IOException {
        saveImage(outputDir + "\\" + title + "_" + resolution + "_chunks" + suffix + ".png", openFileOnSave);
    }

    public void saveImage(String path, boolean openFileOnSave) throws IOException {
        saveImage(image, path, openFileOnSave);
        g.dispose();
    }

    public static void saveImage(BufferedImage bi, String path, boolean openFileOnSave) throws IOException {
        System.out.printf("Saving image %s%n", path);
        File f = new File(path);
        if (!ImageIO.write(bi, "PNG", f)) {
            throw new IOException("Could not write image");
        }
        if (openFileOnSave) {
            try {
                Desktop dt = Desktop.getDesktop();
                dt.open(f);
            } catch (IOException e) {
                System.out.println("Could not open file");
            }
        }
    }
}
