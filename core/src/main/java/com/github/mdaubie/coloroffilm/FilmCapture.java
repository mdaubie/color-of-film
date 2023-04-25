package com.github.mdaubie.coloroffilm;

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

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public void setOutputTitle(String outputTitle) {
        this.outputTitle = outputTitle;
    }
}
