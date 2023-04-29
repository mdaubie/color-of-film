package io.github.mdaubie.coloroffilm.shapers;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BarcodeShaper extends ImageShaper {
    public BarcodeShaper() {
        super("_color_barcode");
    }

    @Override
    protected BufferedImage getImage(int resolution) {
        return new BufferedImage(resolution, resolution, BufferedImage.TYPE_4BYTE_ABGR);
    }

    @Override
    public void paintChunk(Color color, int chunkIdx, int chunkNumber) {
        g.setColor(color);
        g.drawLine(chunkIdx, 0, chunkIdx, chunkNumber);
    }
}
