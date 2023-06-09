# Color of film

[![version](https://img.shields.io/github/v/release/mdaubie/color-of-film?display_name=tag)](https://github.com/mdaubie/color-of-film/releases/latest)
[![release status](https://img.shields.io/github/actions/workflow/status/mdaubie/color-of-film/release.yml?event=push)](https://github.com/mdaubie/color-of-film/actions/workflows/release.yml)
![checks status](https://img.shields.io/github/checks-status/mdaubie/color-of-film/master)
[![publish status](https://github.com/mdaubie/color-of-film/actions/workflows/publish.yml/badge.svg)](https://github.com/mdaubie/color-of-film/actions/workflows/publish.yml)
[![license](https://img.shields.io/github/license/mdaubie/color-of-film)](https://github.com/mdaubie/color-of-film/blob/master/LICENSE)

Builds an image representing the chromatic identity of a film from the average color of its frames.

### How to use

Required parameters:

- video file path (obviously)
- resolution: defines the precision of the image to build.
- shapes: defines the shape(s) of the image to build (see example below)

##### Java:

```java
public class Main {
    public static void main(String filePath, int resolution) throws IOException {
        FilmCapture capture = new FilmCapture(filePath);
        ImageBuilder builder = capture.getBuilder(resolution);
        builder.setShapers(new DiscShaper(), new BarCodeShaper());
        builder.build();
    }
}
```

#### CLI

``` console
cd <filedir>
java -jar color-of-film-cli-1.0.0-jar-with-dependencies.jar -fp <filename> -r 1000 --shapes DISC,BARCODE
```

### Example

Batman Begins (2005) - 1080p YIFY, using a resolution of 1000 chunks, both Barcode and Disc shapes, and all the frames
of the movie:

| Barcode | Disc |
| --- | --- |
| ![Barcode](output/batman_begins_complete_1000_chunks_color_barcode.png) | ![Disc](output/batman_begins_complete_1000_chunks_color_disc.png) |

### How it works

The video file is read using opencv, the video is read frame by frame, for each frame, the mean color value of the frame
is calculated using the library.

The conventional framerate of a movie is 24fps (little less actually), so a 1hour movie is composed of about 86400
frames. Building an image of 86400 pixels aside would be way too costly (around 30 GB of RAM).

Therefore, we split the video in chunks, in which we average the color of all the frames, obtaining a chunk color, which
we paint on the image to build.<br>
The number of chunks is the resolution, so for a resolution of 1000, the provided video is split in 1000 chunks, which
output 1000 colors, which are painted as a line on the output image, in the shape required.

### Warning

The built image is in 32bits, the dimensions are roughly resolution × resolution. During build the image is not
compressed, so the space complexity is quadratic. Therefore, if you use too large resolution you will reach heap space.
For example, using resolution 25000 with the disc shape would result in a 50001 × 50001 image in 32bits which results in
a RAM need of 50001 × 50001 × 4octet = 10 GB

### Notes

- Versioning: I'm sorry about the git history on this repo, it is quite disastrous, this was my first time using
  conventional commits, semantic release, and GitHub Actions, so it's quite dirty, but it should be cleaner from now one

### Related projects

I am working on a web app project to handle my collection of downloaded movies and series, you can find it
here: [The Movie Shelf](https://github.com/mdaubie/movie-shelf)

This is a personal project for my needs, so it probably won't be interesting for you (I might actually keep it private),
but I need to develop some libraries for this main project which might be useful to you:

- [MKV Toolbox](https://github.com/mdaubie/mkv-toolbox)
- [Srt Parser](https://github.com/mdaubie/srt-parser)
- [Torrent Name Parser](https://github.com/mdaubie/torrent-name-parser)
