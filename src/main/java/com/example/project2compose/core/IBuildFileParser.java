package com.example.project2compose.core;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IBuildFileParser {
    IntermediateRepresentation parse(String buildFile) throws Exception;
}
