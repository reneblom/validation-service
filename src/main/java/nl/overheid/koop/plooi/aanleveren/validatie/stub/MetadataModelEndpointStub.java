package nl.overheid.koop.plooi.aanleveren.validatie.stub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

@RestController
public class MetadataModelEndpointStub {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(path = "/validatie/metadata/document/stub")
    public @ResponseBody byte[] getMetadataModel(String metadataFile) {
        logger.info("Start reading metadata-model from {}", metadataFile);
        var file = Paths.get("src", "test", "resources", metadataFile);
        try {
            try (var inputStream = new FileInputStream(String.valueOf(file))) {
                logger.info("End reading metadata-model");
                return inputStream.readAllBytes();
            }
        } catch (IOException e) {
            logger.error("{} not found", metadataFile);
            return new byte[0];
        }
    }
}
