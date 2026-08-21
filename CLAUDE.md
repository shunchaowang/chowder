# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Java coding camp repository containing algorithm implementations organized by problem type. The library includes solutions to various algorithmic problems from sources like LeetCode, along with custom implementations and exercises.

## Build Commands

- **Build the project:** `./gradlew build`
- **Run tests:** `./gradlew test`
- **Run specific test:** `./gradlew test --tests <test-class-name>`
- **Run all tests in a package:** `./gradlew test --tests me.algorithm.array.*`
- **Generate test reports:** Tests produce HTML reports at `lib/build/reports/tests/test/index.html`

## Project Structure

```
lib/src/
├── main/java/me/
│   ├── algorithm/          # Core algorithm implementations
│   │   ├── array/          # Array manipulation problems
│   │   ├── array/matrix/   # Matrix operations
│   │   ├── backtracking/   # Backtracking algorithms
│   │   ├── bfs/            # Breadth-first search
│   │   ├── binarysearch/   # Binary search problems
│   │   ├── crypto/         # Cryptography utilities
│   │   ├── divideconquer/  # Divide and conquer
│   │   ├── dp/             # Dynamic programming
│   │   │   ├── grid/       # Grid-based DP
│   │   │   ├── knapsack/   # Knapsack variants
│   │   │   ├── dualsequence/  # Two sequences DP
│   │   │   ├── interval/   # Interval DP
│   │   │   └── ...
│   │   ├── graph/          # Graph algorithms
│   │   ├── heap/           # Heap operations
│   │   ├── leetcode/       # LeetCode-style problems
│   │   ├── list/           # Linked list operations
│   │   ├── number/         # Number theory
│   │   ├── oopdesign/      # Object-oriented design problems
│   │   ├── prefixsum/      # Prefix sum utilities
│   │   ├── priorityqueue/  # Priority queue problems
│   │   ├── slidingwindow/  # Sliding window algorithms
│   │   ├── sorting/        # Sorting algorithms
│   │   ├── stack/          # Stack problems
│   │   ├── string/         # String manipulation
│   │   ├── tree/           # Tree data structures
│   │   └── trie/           # Trie implementations
│   └── playground/         # Playground/initialization examples
└── test/java/me/
    └── [same structure as main with *Test suffix]
```

## Coding Patterns

- All classes are public with no default constructor (use static factory methods where applicable)
- Solution classes typically use `private` constructors to prevent instantiation
- Each algorithm file includes Javadoc comments with problem description and constraints
- Tests use JUnit 5 with `@Test`, `@DisplayName`, and SLF4J for logging
- Main method in some files provides example usage (Graph.java, for instance)

## Algorithm Categories

- **Array Problems:** TwoSum, RotateArray, MaxSubArray, etc.
- **Matrix Problems:** SpiralMatrix, RotateImage, GameOfLife, etc.
- **Graph Algorithms:** Graph traversal, WordLadder, SurroundedRegions
- **Dynamic Programming:** Knapsack variants, Fibonacci, Grid Traveler
- **Backtracking:** N-Queens, CombinationSum, Subsets
- **Trie Operations:** WordDictionary, WordSearchII
- **Sliding Window:** LongestSubstring, MinimumSizeSubarraySum
- **LeetCode Collections:** Categorized by topic (arrayandhashing, binarysearch, linkedlist, etc.)

## Dependencies

- JUnit Jupiter 5.12.1 for testing
- Apache Commons Math3 (3.6.1)
- Google Guava (33.4.6-jre)
- SLF4J + Log4j2 for logging
- Java 25 toolchain (configured in build.gradle)