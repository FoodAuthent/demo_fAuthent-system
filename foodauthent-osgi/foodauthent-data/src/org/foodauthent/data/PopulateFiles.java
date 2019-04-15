package org.foodauthent.data;

import static org.foodauthent.data.FASystem.files;
import static org.foodauthent.data.FASystem.products;
import static org.foodauthent.data.FASystem.uploadFileData;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.FileMetadata.TypeEnum;

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
    public static void populateFiles(List<File> files, Map<String, UUID> name2uuidMap) {
	for (File f : files) {
	    String fileNameWithoutExtension = f.getName().split("\\.")[0];
	    uploadFileData(name2uuidMap.get(fileNameWithoutExtension), f);
	}
    }
   
    public static List<UUID> populateFileMetadata(List<FileMetadata> meta) {
	return meta.stream().map(m -> files().createFileMetadata(m).readEntity(UUID.class))
		.collect(Collectors.toList());
    }
  
}
