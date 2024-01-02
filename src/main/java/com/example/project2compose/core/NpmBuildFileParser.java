package com.example.project2compose.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;

import java.util.Map;
import java.util.stream.StreamSupport;

public class NpmBuildFileParser implements IBuildFileParser {
    @Override
    public IntermediateRepresentation parse(String buildFile) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        JsonNode tree = om.readTree(buildFile);

        return new IntermediateRepresentation(
            BuildSystem.NPM,
            tree.get("name").asText(),
            tree.get("version").asText(),
            StreamSupport.stream(tree.get("dependencies").spliterator(), false)
                    .map(dependency -> dependency.asText())
                    .toArray(String[]::new)

        );
    }
}
