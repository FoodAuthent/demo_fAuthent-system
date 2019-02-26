package org.foodauthent.impl.file;

import java.io.File;

import org.foodauthent.model.FaObjectSet;

public interface Exporter {
	void export(FaObjectSet objectSet, File file);
}
