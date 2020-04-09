package se.anosh.gbs.domain;

public interface ReadOnlyTag {

	String getAuthor();
	String getTitle();
	String getCopyright();
	
	public byte getVersionNumber();
	public int getNumberOfSongs();
	public int getFirstSong();
	
	public String getHeader();
	
}
