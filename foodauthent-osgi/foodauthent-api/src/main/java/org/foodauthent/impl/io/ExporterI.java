package org.foodauthent.impl.io;

import java.io.File;

import org.foodauthent.model.FaObjectSet;

public interface ExporterI {
	void export(FaObjectSet objectSet, File file);
}
