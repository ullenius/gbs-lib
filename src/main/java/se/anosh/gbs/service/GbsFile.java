package se.anosh.gbs.service;

import java.io.IOException;

import se.anosh.gbs.dao.GbsFileReader;
import se.anosh.gbs.dao.GbsFileWriter;
import se.anosh.gbs.dao.TagReader;
import se.anosh.gbs.domain.GbsTag;

public class GbsFile implements Gbs {

	private TagReader reader;
	private GbsTag tag;

	private final String filename;

	public GbsFile(String fileName) throws IOException {
		this.filename = fileName;
		reader = new GbsFileReader(fileName);
		tag = reader.getTags();
	}

	public void save() throws IOException {
		try (GbsFileWriter writer = new GbsFileWriter(filename, tag)) {
			writer.writeAuthor();
			writer.writeCopyright();
			writer.writeTitle();
		}
	}
	
	@Override
	public String toString() {
		return getFileName();
	}

	@Override
	public String getFileName() {
		return this.filename;
	}
	

	@Override
	public GbsTag getTag() {
		return tag;
	}
	


}