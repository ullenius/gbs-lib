package se.anosh.gbs.domain;

public interface ReadOnlyLowLevelGbsTag {

	byte getVersionNumber();
	int getNumberOfSongs();
	int getFirstSong();
	String getHeader();

}
