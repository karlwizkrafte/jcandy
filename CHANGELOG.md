# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [1.1.0] - 2025-08-17
### Added
- Support for HEX and RGB color formats for both foreground (`Color`) and background (`BGColor`) enums:
	- `Color.hex("#RRGGBB")` and `Color.rgba(r, g, b, a)` for custom text colors.
	- `BGColor.hex("#RRGGBB")` and `BGColor.rgba(r, g, b, a)` for custom background colors.
	- Accepts 6-digit (RGB) and 8-digit (RGBA) HEX codes (alpha channel ignored by ANSI rendering).
	- 8-digit HEX accepted for convenience; alpha is discarded.

## [1.0.0] - 2025-08-13
### Added
- Public release of CLI utilities library
- Refactored and enhanced from internal prototype
- `Flavorful` class providing:
	- Text colors (`Color` enum)
	- Background colors (`BGColor` enum)
	- Text styles (`Style` enum)
	- Convenience formatting helpers (`flavor`, `bold`, `underline`, etc.)
- `Std` class offering standardized CLI utilities:
	- Formatted output (`print`, `println`, `printf`)
	- Error output (`printError`)
	- Helpers for newlines (`newl`), delays (`delay`), and clearing the terminal (`clear`).

## [0.1.0] - 2025-06-13
### Added
- Initial internal prototype (`kvx.cli` package)
- Basic ANSI terminal formatting with `format()` method
- Core CLI utilities: `print`, `printError`, `newl`, `delay`, `clear`
- Support for standard and bright ANSI colors
- Cross-platform terminal clearing functionality
---

[Unreleased]: https://github.com/karlwizkrafte/jcandy/compare/v1.1.0...HEAD
[1.1.0]: https://github.com/karlwizkrafte/jcandy/compare/v1.0.0...v1.1.0
[1.0.0]: https://github.com/karlwizkrafte/jcandy/releases/tag/v1.0.0
