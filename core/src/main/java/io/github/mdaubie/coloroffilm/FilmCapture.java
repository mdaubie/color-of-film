package io.github.mdaubie.coloroffilm;

import nu.pattern.OpenCV;
import org.opencv.core.CvException;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import java.io.File;
import java.security.InvalidParameterException;

//TODO add multiple file handling (series)
public class FilmCapture extends VideoCapture {
    protected String outputTitle;
    protected String outputDir;
    public final File file;
    public final int framesNumber;

    static {
        OpenCV.loadShared();
    }

    public FilmCapture(String filePath) {
        super(filePath);
        this.file = new File((new File(filePath)).getAbsolutePath());
        System.out.printf("Accessing file %s%n", file.getAbsolutePath());
        if (!file.isFile()) throw new InvalidParameterException("File does not exists");
        if (!this.isOpened())
            throw new CvException("Capture cannot be opened");
        System.out.println("Video Capture opened");
        framesNumber = (int) get(Videoio.CAP_PROP_FRAME_COUNT);
        double frameRate = get(Videoio.CAP_PROP_FPS);
        System.out.printf("Number of frames: %d (%,.2f fps)%n", framesNumber, frameRate);
    }

    public ImageBuilder getBuilder(int resolution) {
        return getBuilder(resolution, framesNumber - 1);
    }

    public ImageBuilder getBuilder(int resolution, int endFrameIdx) {
        return getBuilder(resolution, 0, endFrameIdx);
    }

    public ImageBuilder getBuilder(int resolution, int startFrameIdx, int endFrameIdx) {
        if (outputTitle == null)
            outputTitle = file.getName();
        if (outputDir == null)
            outputDir = file.getParent();
        System.out.printf("Output directory: %s%n", outputDir);
        if (startFrameIdx < 0 || startFrameIdx > endFrameIdx || endFrameIdx >= framesNumber)
            throw new InvalidParameterException("Invalid start or end frame index");
        ImageBuilder builder = new ImageBuilder(this, resolution, startFrameIdx, endFrameIdx);
        if (startFrameIdx == 0 && endFrameIdx == framesNumber - 1)
            outputTitle += "_complete";
        else
            outputTitle += "_frame_" + startFrameIdx + "_to_" + endFrameIdx;
        builder.setOutputTitle(outputTitle);
        return builder;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public void setOutputTitle(String outputTitle) {
        this.outputTitle = outputTitle;
    }
}
