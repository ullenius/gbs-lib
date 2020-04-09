package se.anosh.gbs.domain;

public interface ReadOnlyTagLowLevel {

	byte getVersionNumber();
	int getNumberOfSongs();
	int getFirstSong();
	String getHeader();

}
