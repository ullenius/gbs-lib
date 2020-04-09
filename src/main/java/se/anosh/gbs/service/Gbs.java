package se.anosh.gbs.service;

import java.io.IOException;

import se.anosh.gbs.domain.ReadOnlyGbsTag;
import se.anosh.gbs.domain.ReadOnlyTagLowLevel;
import se.anosh.gbs.domain.SimpleGbsTag;

public interface Gbs {

	SimpleGbsTag getTag();
	ReadOnlyGbsTag getReadOnlyTag();
	ReadOnlyTagLowLevel getLowLevelTag();

	void save() throws IOException;
	String getFileName();

}