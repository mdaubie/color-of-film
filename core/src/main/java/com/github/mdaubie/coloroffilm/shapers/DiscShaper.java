package com.github.mdaubie.coloroffilm.shapers;

import java.awt.*;
import java.awt.image.BufferedImage;

//TODO improve painting, some pixels are left transparent
public class DiscShaper extends ImageShaper {
    public DiscShaper() {
        super("_color_disc");
    }

    @Override
    protected BufferedImage getImage(int resolution) {
        int size = resolution * 2 + 1;
        return new BufferedImage(size, size, BufferedImage.TYPE_4BYTE_ABGR);
    }

    @Override
    public void paintChunk(Color color, int chunkIdx, int chunkNumber) {
        g.setColor(color);
        g.drawOval(chunkIdx, chunkIdx, (chunkNumber - chunkIdx) * 2, (chunkNumber - chunkIdx) * 2);
    }
}
