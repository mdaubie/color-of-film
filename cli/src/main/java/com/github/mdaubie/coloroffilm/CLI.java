package com.github.mdaubie.coloroffilm;

import com.github.mdaubie.coloroffilm.shapers.ImageShaper;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.IOException;
import java.util.concurrent.Callable;

@Command(name = "color-of-film", description = {"Compute a color representation for a single video file"})
public class CLI implements Callable<Integer> {
    @Option(names = {"-fp", "--file_path"}, required = true,
            description = {"Path of the video file to scan"})
    private String filePath;

    @Option(names = {"-r", "--resolution"},
            description = {"Number of chunks to analyze in the video, results in the number of colored line in the output"})
    private int resolution = 1000;

    @Option(names = {"-s", "--shapes"}, split = ",", required = true,
            description = {"Shape(s) of the output(s), you should specify at least one and can specify several, %nAvailable shapes: ${COMPLETION-CANDIDATES}"})
    private ImageShaper.SHAPES[] shapes;

    @Option(names = {"-od", "--output_dir"},
            description = {"Directory in which to print the output, defaults to the directory of the provided file"})
    private String outputDir;

    @Option(names = {"-ot", "--output_title"},
            description = {"Title of the build image(s), empty by default"})
    private String outputTitle;

    @Option(names = {"-sf", "--start-frame"},
            description = {"Index of the first frame to read, defaults to the index of the first frame of the video (0)"})
    private Integer startFrameIdx;

    @Option(names = {"-ef", "--end-frame"},
            description = {"Index of the last frame to read, defaults to the index of the last frame of the video"})
    private Integer endFrameIdx;

    @Option(names = {"-of", "--open-file"},
            description = {"Describes whether to open the built images at the end of the process or not, defaults to false"})
    private boolean openFile = false;

    public Integer call() {
        FilmCapture capture = new FilmCapture(this.filePath);
        if (this.outputDir != null)
            capture.setOutputDir(this.outputDir);
        if (this.outputTitle != null)
            capture.setOutputTitle(this.outputTitle);

        ImageBuilder builder;
        if (this.endFrameIdx == null) {
            builder = capture.getBuilder(this.resolution);
        } else {
            if (this.startFrameIdx == null)
                this.startFrameIdx = 0;
            builder = capture.getBuilder(this.resolution, this.startFrameIdx, this.endFrameIdx);
        }

        builder.setShapers(this.shapes);
        builder.setOpenFileOnSave(this.openFile);

        try {
            builder.build();
        } catch (IOException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.exit(new CommandLine(new CLI()).execute(args));
    }
}
