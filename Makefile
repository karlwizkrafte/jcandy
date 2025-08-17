.PHONY: all compile run test clean help

# Java build settings
SRC := $(wildcard src/kvx/jcandy/*.java)
TESTS := $(wildcard tests/kvx/jcandy/*.java)
OUT := out/classes

JAVAC := javac
JAVA := java
MAIN := tests.kvx.jcandy.RunAllTests
JFLAGS := -d $(OUT)

all: compile

compile: $(OUT) $(SRC) $(TESTS)
	$(JAVAC) $(JFLAGS) $(SRC) $(TESTS)

$(OUT):
	mkdir -p $(OUT)

run: compile
	$(JAVA) -cp $(OUT) $(MAIN)

test: run

# Run using the POSIX bash helper (useful when Make runs under Git Bash / MSYS)
.PHONY: run-sh
run-sh:
	@if command -v bash >/dev/null 2>&1; then \
		bash run-tests.sh; \
	else \
		echo "bash not found; run 'make run' or use Git Bash/WSL"; exit 1; \
	fi

clean:
	rm -rf $(OUT)

help:
	@echo "Makefile targets:"
	@echo "  make         (same as make compile)"
	@echo "  make compile Compile sources and tests into out/classes"
	@echo "  make run     Compile (if needed) and run tests"
	@echo "  make test    Alias for make run"
	@echo "  make clean   Remove compiled classes"