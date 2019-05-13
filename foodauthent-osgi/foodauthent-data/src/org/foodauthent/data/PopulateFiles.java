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
    public static void populateFiles(List<File> files, Map<String, UUID> name2uuidMap, FASystemClient c) {
	for (File f : files) {
	    String fileNameWithoutExtension = f.getName().split("\\.")[0];
	    uploadFileData(name2uuidMap.get(fileNameWithoutExtension), f, c);
	}
    }
   
    public static List<UUID> populateFileMetadata(List<FileMetadata> meta, FASystemClient c) {
	return meta.stream().map(m -> files(c).createFileMetadata(m).readEntity(UUID.class))
		.collect(Collectors.toList());
    }
  
}
