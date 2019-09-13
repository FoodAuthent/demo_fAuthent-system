package org.foodauthent.data;

import static org.foodauthent.rest.client.FASystemClientUtil.files;
import static org.foodauthent.rest.client.FASystemClientUtil.uploadFileData;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.foodauthent.model.FileMetadata;
import org.foodauthent.rest.client.FASystemClient;

/**
 * 
 * @author Martin Horn, University of Konstanz
 */
public class PopulateFiles {

    private PopulateFiles() {
	// utility class
    }
    
    /**
     * Assumption is that the file names (without extension) matches the name in the
     * passed map.
     * 
     * @param files
     * @param type
     */
    public static void populateFilesWithMetadata(List<File> files, List<FileMetadata> metadata, FASystemClient c) {

	Map<String, FileMetadata> name2metaMap = metadata.stream().collect(Collectors.toMap(m -> m.getName(), m -> m));
	for (File f : files) {
	    String fileNameWithoutExtension = f.getName().split("\\.")[0];

	    FileMetadata fileMetadata = name2metaMap.get(fileNameWithoutExtension);
	    if (fileMetadata != null) {
		// only populate metadata that has a corresponding file
		populateFileMetadata(fileMetadata, c);
		uploadFileData(fileMetadata.getFaId(), f, c);
	    }
	}
    }

    private static UUID populateFileMetadata(FileMetadata meta, FASystemClient c) {
	return files(c).createFileMetadata(meta).readEntity(UUID.class);
    }

}
