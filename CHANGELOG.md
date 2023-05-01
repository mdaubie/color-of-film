# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.0.1] - 2023-05-01
### :bug: Bug Fixes
- [`46f625d`](https://github.com/mdaubie/color-of-film/commit/46f625d2ba0d99b4b37ace236bdc48b155fbb5e1) - **release**: correct git tag deletion command *(commit by [@mdaubie](https://github.com/mdaubie))*
- [`29bf798`](https://github.com/mdaubie/color-of-film/commit/29bf7986a924c7708dd2449268b76fc6ae4d41c5) - **release**: correct versions commit step *(commit by [@mdaubie](https://github.com/mdaubie))*
- [`49c351d`](https://github.com/mdaubie/color-of-film/commit/49c351d9d5620e2e51f5cdc6193097a9bb562c9f) - **release**: change release tag pointer from merge commit to last version commit *(commit by [@mdaubie](https://github.com/mdaubie))*

### :recycle: Refactors
- [`f979a98`](https://github.com/mdaubie/color-of-film/commit/f979a9856d10537d21522de1299eb335cb2d6ae2) - **release**: change release branch from master to release *(commit by [@mdaubie](https://github.com/mdaubie))*
- [`9575ac4`](https://github.com/mdaubie/color-of-film/commit/9575ac41ba313776b5b9d0fe76773c66e520cce7) - **publish**: change publish branch from stable to publish *(commit by [@mdaubie](https://github.com/mdaubie))*

### :memo: Documentation Changes
- [`de028a0`](https://github.com/mdaubie/color-of-film/commit/de028a0c358ad271aad934688cc81c65406e830d) - add badges to README *(commit by [@mdaubie](https://github.com/mdaubie))*
- [`c6722ba`](https://github.com/mdaubie/color-of-film/commit/c6722ba9628396907ffba88e3104637edef0cc7a) - add links to the appropriate resource on the README badges *(commit by [@mdaubie](https://github.com/mdaubie))*

### :art: Code Style Changes
- [`802d2c3`](https://github.com/mdaubie/color-of-film/commit/802d2c3e1e861c51d4b9fabe7bc6863335b8a4a1) - shorten publish job name, so it look nicer in the README *(commit by [@mdaubie](https://github.com/mdaubie))*


## [1.0.0] - 2023-04-29
### :boom: BREAKING CHANGES
- due to [`ee14bc1`](https://github.com/mdaubie/color-of-film/commit/ee14bc10966c52d3c525a7bcde7cf7fef7af386f) - add CLI with picocli library *(commit by [@mdaubie](https://github.com/mdaubie))*:

  add CLI with picocli library


### :sparkles: New Features
- [`ae7bfde`](https://github.com/mdaubie/color-of-film/commit/ae7bfdec76481a59f1b9dfa24318141e99d8e1a6) - **cli**: add cli module to Maven project *(commit by [@mdaubie](https://github.com/mdaubie))*
- [`ee14bc1`](https://github.com/mdaubie/color-of-film/commit/ee14bc10966c52d3c525a7bcde7cf7fef7af386f) - **cli**: add CLI with picocli library *(commit by [@mdaubie](https://github.com/mdaubie))*

### :bug: Bug Fixes
- [`cf4f047`](https://github.com/mdaubie/color-of-film/commit/cf4f047aa22e4aa675aaa7cd0429e0f193dc6e44) - **cli**: correct parent artifact version in cli pom *(commit by [@mdaubie](https://github.com/mdaubie))*

### :recycle: Refactors
- [`9720e70`](https://github.com/mdaubie/color-of-film/commit/9720e707ce91edddd6429cd0ba4805e42459f643) - **cli**: update core dependency version to match last published version 0.4.0 *(commit by [@mdaubie](https://github.com/mdaubie))*

### :construction_worker: Build System
- [`20be0f6`](https://github.com/mdaubie/color-of-film/commit/20be0f6c30390785feaa3ae03a6a2bdfdadd13f1) - **cli**: add jar-with-dependencies build configuration for CLI *(commit by [@mdaubie](https://github.com/mdaubie))*
- [`388379d`](https://github.com/mdaubie/color-of-film/commit/388379dcb270d61415b1a33ae7aba70afc4d73fb) - **publish**: add Maven distribution configuration with ossrh *(commit by [@mdaubie](https://github.com/mdaubie))*
- [`8330ee9`](https://github.com/mdaubie/color-of-film/commit/8330ee92679151a1471f3445415211ba232613ab) - **publish**: add publish workflow with ossrh *(commit by [@mdaubie](https://github.com/mdaubie))*
- [`2fca8b8`](https://github.com/mdaubie/color-of-film/commit/2fca8b8951200becfcfdc6270188c2b7982edf08) - **publish**: add artifact signing with gpg *(commit by [@mdaubie](https://github.com/mdaubie))*

### :memo: Documentation Changes
- [`eb93fee`](https://github.com/mdaubie/color-of-film/commit/eb93feea9597767014b3f860cc603e94dc69fd52) - **cli**: add bash snippet in README to execute CLI *(commit by [@mdaubie](https://github.com/mdaubie))*


## [0.4.0] - 2023-04-29
### :sparkles: New Features
- [`d87b577`](https://github.com/mdaubie/color-of-film/commit/d87b5776d4995ec4baf90576bc9e625f937f05b7) - **core**: add SHAPES enum for CLI support *(commit by [@mdaubie](https://github.com/mdaubie))*

### :recycle: Refactors
- [`fcb9fcb`](https://github.com/mdaubie/color-of-film/commit/fcb9fcb371fc4fb3a051e29f07fe2208de0ffdac) - **core**: update core base package from com to io *(commit by [@mdaubie](https://github.com/mdaubie))*


## [0.3.5] - 2023-04-28
### :bug: Bug Fixes
- [`fe7f2f6`](https://github.com/mdaubie/color-of-film/commit/fe7f2f6336288900316902eb194ab0ad5c5356b5) - **publish**: Prevent gpg from using pinentry programs *(commit by [@mdaubie](https://github.com/mdaubie))*


## [0.3.4] - 2023-04-28
### :construction_worker: Build System
- [`6a18693`](https://github.com/mdaubie/color-of-film/commit/6a18693a5dd5620075ee727b6eac92bb2bd4415c) - **publish**: add artifact signing with gpg *(commit by [@mdaubie](https://github.com/mdaubie))*


## [0.3.1] - 2023-04-28
### :bug: Bug Fixes
- [`a1eecf3`](https://github.com/mdaubie/color-of-film/commit/a1eecf34f44a2aa2d995359e0da02a109a41d83d) - **release**: add module poms in the Maven version commit *(commit by [@mdaubie](https://github.com/mdaubie))*
- [`95a17f6`](https://github.com/mdaubie/color-of-film/commit/95a17f69eb1a54a93c65c26b4541a67260850f4b) - **release**: Rollback 854cfe2, the next tag need to be pushed on origin for changelog step *(commit by [@mdaubie](https://github.com/mdaubie))*

### :recycle: Refactors
- [`854cfe2`](https://github.com/mdaubie/color-of-film/commit/854cfe2f6807072953d7f531ac33a7944735a518) - **release**: remove new tag push, since it will be on create release step, remove deletion tag step too *(commit by [@mdaubie](https://github.com/mdaubie))*

### :construction_worker: Build System
- [`e28da52`](https://github.com/mdaubie/color-of-film/commit/e28da52b9cac82d43ec3a47d3da4f60c611eddc6) - **release**: add build and cd to the patch type list for versioning *(commit by [@mdaubie](https://github.com/mdaubie))*


## [0.3.0] - 2023-04-28
### :sparkles: New Features
- [`cb7d00d`](https://github.com/mdaubie/color-of-film/commit/cb7d00d6c291232be84957f9df247b6c264d27fa) - **core**: add getBuilder wrapper method to instanciate the ImageBuilder class from VideoCapture class *(commit by [@mdaubie](https://github.com/mdaubie))*


## [0.2.0] - 2023-04-28
### :sparkles: New Features
- [`efe44f7`](https://github.com/mdaubie/color-of-film/commit/efe44f7f5ac2684e49cddc328c4db950007c921e) - **core**: add option to automatically open generated images after build *(commit by [@mdaubie](https://github.com/mdaubie))*
- [`5eb356d`](https://github.com/mdaubie/color-of-film/commit/5eb356d689b6012880f36202b086467e0a44255f) - **core**: add a progress display during build *(commit by [@mdaubie](https://github.com/mdaubie))*
- [`6e2674c`](https://github.com/mdaubie/color-of-film/commit/6e2674c9073870bb32454c16d49397520890d74a) - **core**: add disc shaper, generate a round image *(commit by [@mdaubie](https://github.com/mdaubie))*

### :memo: Documentation Changes
- [`893bff1`](https://github.com/mdaubie/color-of-film/commit/893bff10764322994f8706aa23ed49940a407089) - **README**: add 'How to use' section *(commit by [@mdaubie](https://github.com/mdaubie))*


## [0.1.0] - 2023-04-27
### :sparkles: New Features
- [`a19f2e8`](https://github.com/mdaubie/color-of-film/commit/a19f2e877b0a612f2162d2b03af43610cd57f836) - core module; video capture with opencv; FilmCapture class, handling video capture; print capture infos *(commit by [@mdaubie](https://github.com/mdaubie))*
- [`639dc22`](https://github.com/mdaubie/color-of-film/commit/639dc229c97b77aef654e7d39c5922a52334d6ff) - add image builder class; add abstract shaper class; add first concrete shaper; build info printing *(commit by [@mdaubie](https://github.com/mdaubie))*


## [0.0.2] - 2023-04-27
### :bug: Bug Fixes
- [`8ebbdef`](https://github.com/mdaubie/color-of-film/commit/8ebbdefe042c5c2ec2df98e5e1dc8623080dd9b0) - **release**: update deletion tag to apply on origin *(commit by [@mdaubie](https://github.com/mdaubie))*


[0.0.2]: https://github.com/mdaubie/color-of-film/compare/0.0.1...0.0.2
[0.1.0]: https://github.com/mdaubie/color-of-film/compare/0.0.2...0.1.0
[0.2.0]: https://github.com/mdaubie/color-of-film/compare/0.1.0...0.2.0
[0.3.0]: https://github.com/mdaubie/color-of-film/compare/0.2.0...0.3.0
[0.3.1]: https://github.com/mdaubie/color-of-film/compare/0.3.0...0.3.1
[0.3.4]: https://github.com/mdaubie/color-of-film/compare/0.3.3...0.3.4
[0.3.5]: https://github.com/mdaubie/color-of-film/compare/0.3.4...0.3.5
[0.4.0]: https://github.com/mdaubie/color-of-film/compare/0.3.5...0.4.0
[1.0.0]: https://github.com/mdaubie/color-of-film/compare/0.4.0...1.0.0
[1.0.1]: https://github.com/mdaubie/color-of-film/compare/1.0.0...1.0.1