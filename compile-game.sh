#!/bin/bash

# Define source and destination directories
SRC_DIR="src"
CLASSES_DIR="classes"

# Create the classes directory if it doesn't exist
mkdir -p "$CLASSES_DIR"

# Find all Java files in the source directory
find "$SRC_DIR" -name "*.java" > sources.txt

# Compile Java files
javac -d "$CLASSES_DIR" -cp "$SRC_DIR" @sources.txt

# Clean up temporary file
rm sources.txt

