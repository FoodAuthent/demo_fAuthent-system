package org.foodauthent.impl.file;

import java.io.File;

import org.foodauthent.model.FaObjectSet;

public interface Importer {
    
    FaObjectSet importData(File file);
}
