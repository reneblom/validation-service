package nl.overheid.koop.plooi.aanleveren.validatie.stub;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MetadataModelEndpointStubTest {

    final static private String METADATA_FILE = "metadata-v1.yaml";
    final private MetadataModelEndpointStub metadataModelEndpointStub = new MetadataModelEndpointStub();

    @Test
    public void fileExistsAndReturnsContent() {
        var content = metadataModelEndpointStub.getMetadataModel(METADATA_FILE);
        assertTrue(content.length > 0);
    }

    @Test
    public void fileDoesNotExistsAndReturnsNoContent() {
        var content = metadataModelEndpointStub.getMetadataModel(METADATA_FILE + ".error");
        assertEquals(0,
                content.length);
    }

}
