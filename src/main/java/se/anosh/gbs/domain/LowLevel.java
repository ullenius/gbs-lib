package se.anosh.gbs.domain;

public interface LowLevel {

	byte getVersionNumber();
	int getNumberOfSongs();
	int getFirstSong();
	String getHeader();

}
