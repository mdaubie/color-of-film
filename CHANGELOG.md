# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

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