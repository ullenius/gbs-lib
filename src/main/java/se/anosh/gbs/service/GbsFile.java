package se.anosh.gbs.service;

import java.io.IOException;

import se.anosh.gbs.dao.*;
import se.anosh.gbs.domain.Tag;

public class GbsFile implements Gbs {

	private final Tag tag;
	private final String filename;

	public GbsFile(String fileName) throws IOException {
		this.filename = fileName;
		TagReader reader = new GbsFileReader(fileName);
		tag = reader.getTags();
	}

	public void save() throws IOException {
		try (TagWriter writer = new GbsFileWriter(filename, tag)) {
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
	public Tag getTag() {
		return tag;
	}

}