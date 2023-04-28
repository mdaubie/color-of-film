package com.github.mdaubie.coloroffilm;

import com.github.mdaubie.coloroffilm.shapers.ImageShaper;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.videoio.Videoio;

import java.awt.*;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ImageBuilder {
    private final FilmCapture capture;
    private final int startFrameIdx;
    private final int endFrameIdx;
    private final int resolution;
    private ImageShaper[] shapers;
    private String outputTitle = "";
    private boolean openFileOnSave = false;

    //Recommended to use de FilmCapture.getBuilder() method
    public ImageBuilder(FilmCapture capture, int resolution, int startFrameIdx, int endFrameIdx) {
        this.capture = capture;
        this.resolution = resolution;
        this.startFrameIdx = startFrameIdx;
        this.endFrameIdx = endFrameIdx;
    }

    public void build() throws IOException {
        if (shapers == null) throw new InvalidParameterException("No image painters provided");
        int numberOfFrames = endFrameIdx - startFrameIdx + 1;
        System.out.printf("Output title: %s%n", outputTitle);
        System.out.printf("Reading frames %d to %d (%d frames)%n", startFrameIdx, endFrameIdx, numberOfFrames);
        System.out.printf("Resolution: %d%n", resolution);
        System.out.printf("Registered shapers: %s%n", Arrays.stream(shapers).map(s -> s.getClass().getSimpleName()).collect(Collectors.toList()));
        Mat frame = new Mat();
        for (ImageShaper painter : shapers)
            painter.build(resolution);

        float averageChunkSize = (float) numberOfFrames / resolution;
        capture.set(Videoio.CAP_PROP_POS_FRAMES, startFrameIdx);
        int frameIdx = startFrameIdx;
        ProgressDisplay progressDisplay = new ProgressDisplay(resolution);
        for (int chunkIndex = 0; chunkIndex < resolution; chunkIndex++) {
            int chunkLimitIdx = (int) (averageChunkSize * (chunkIndex + 1));
            int chunkSize = chunkLimitIdx - frameIdx;
            long t0 = System.currentTimeMillis();

            //Calculating mean chunk value for each RGB color
            double chunkBlue = 0;
            double chunkGreen = 0;
            double chunkRed = 0;
            while (frameIdx < chunkLimitIdx) {
                capture.read(frame);
                Scalar scalar = Core.mean(frame);
                chunkBlue += scalar.val[0] / chunkSize;
                chunkGreen += scalar.val[1] / chunkSize;
                chunkRed += scalar.val[2] / chunkSize;
                frameIdx++;
            }
            Color chunkColor = new Color((int) chunkRed, (int) chunkGreen, (int) chunkBlue);
            for (ImageShaper painter : shapers)
                painter.paintChunk(chunkColor, chunkIndex, resolution);
            long chunkDuration = System.currentTimeMillis() - t0;
            progressDisplay.print(chunkIndex + 1, chunkDuration);
        }
        System.out.println();
        progressDisplay.printCompletion();
        capture.release();
        for (ImageShaper painter : shapers)
            painter.saveImage(capture.outputDir, outputTitle, openFileOnSave);
    }

    public void setShapers(ImageShaper... shapers) {
        this.shapers = shapers;
    }

    public void setShapers(ImageShaper.SHAPES... shapers) {
        this.shapers = Arrays.stream(shapers).map(ImageShaper.SHAPES::getInstance).toArray(ImageShaper[]::new);
    }

    public void setOutputTitle(String outputTitle) {
        this.outputTitle = outputTitle;
    }

    public void setOpenFileOnSave(boolean openFileOnSave) {
        this.openFileOnSave = openFileOnSave;
    }
}
