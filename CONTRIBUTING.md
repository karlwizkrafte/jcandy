# Contributing to JCandy

Thank you for your interest in contributing to JCandy. Contributions of all kinds are welcome: bug fixes, tests, documentation and new features.

## Developing

Keep changes small and focused. A few simple guidelines to help your pull request get accepted quickly:

 - Document public behavior and any tricky implementation details.
 - Prefer clear, descriptive names rather than abbreviations for classes, variables and methods.
 - Follow the project's existing coding style and API conventions.
 - Add or update tests for new behavior and for fixed bugs.

### New Features

JCandy aims to reduce boilerplate and provide lightweight Java wrappers to make development and prototyping for laboratory tasks faster and easier. New features should support that goal. Prefer small, focused additions that improve the developer experience, such as concise helpers, thin wrappers around verbose APIs, test utilities, and small adapters.

Please avoid large, domain-specific or heavy-weight additions that do not fit the project's scope. Examples of discouraged contributions include full algorithm libraries, complete machine learning frameworks, extensive GUI toolkits, or large application-specific modules. If you are unsure whether a proposed feature fits, open an issue first to discuss the idea.

### Running tests

Before committing, run the test suite and make sure new and existing tests pass.

The project provides a Makefile target to run tests:

```
make test
```

It is suggested to install make or run the tests manually. On Windows, install a compatible make tool or run the commands the Makefile invokes directly; open `Makefile` to see the exact commands.

## Commit checklist

Before opening a pull request, make sure:

1. The code builds and all tests pass locally.
2. You included or updated tests for your changes where appropriate.
3. The changes are documented in code and, when needed, in the README or other docs.
4. Commits are focused and atomic. Squash or rebase as needed before submitting.
5. Commit messages follow the Conventional Commits specification to keep history clear and support automated changelogs and releases. See [Conventional Commits specification](https://www.conventionalcommits.org/en/v1.0.0/) for the full guide. Example messages:

	* feat: add helper for X
	* fix: correct null handling in Y
	* docs: update CONTRIBUTING.md

## Creating a Pull Request

 - Fork the repository and create a feature branch from `master`.
 - Make your changes, run the tests and commit with clear messages.
 - Push your branch and open a pull request against `master` with a short description of the change and why it is needed.

I will review your pull request and provide feedback or merge it once it is ready. Thank you for contributing.

## Questions or help

If you are unsure where to start, open an issue describing what you would like to work on or ask for guidance in the pull request. I will help you finish it.