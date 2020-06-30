package se.anosh.gbs.dao;

import java.io.*;

public interface TagWriter extends Closeable {
	
	public void writeTitle() throws IOException;
	public void writeAuthor() throws IOException;
	public void writeCopyright() throws IOException;

}
