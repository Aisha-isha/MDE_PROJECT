package com.example.project2compose.core;

public record IntermediateRepresentation(
    BuildSystem buildSystem,
    String name,
    String version,
    String[] dependencies
) { }
