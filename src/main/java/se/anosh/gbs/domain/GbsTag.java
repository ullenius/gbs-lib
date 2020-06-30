package se.anosh.gbs.domain;

import java.util.*;

/* Domain class for GBS-files 
 * 
 */
public class GbsTag implements SimpleGbsTag, ReadOnlySimpleGbsTag, LowLevel, ReadOnlyGbsTag, Tag, Comparable<GbsTag> {
	
	// Thanks to Lukasz Wiktor @ stack overflow (2014)
    private static final Comparator<String> nullSafeStringComparator = Comparator.nullsFirst(String::compareToIgnoreCase);
    private static final Comparator<GbsTag> gbsComparator = Comparator
            .comparing(GbsTag::getTitle, nullSafeStringComparator)
            .thenComparing(GbsTag::getAuthor, nullSafeStringComparator)
            .thenComparing(GbsTag::getCopyright, nullSafeStringComparator);
	private String header;
	private String author;
	private String title;
	private String copyright;
	
	private int numberOfSongs; //1-255 (1 byte) but since Java doesn't support unsigned values int is used
	private int firstSong;
	private byte versionNumber;  // doesn't matter
	
	public byte getVersionNumber() {
		return versionNumber;
	}
	public void setVersionNumber(byte versionNumber) {
		this.versionNumber = versionNumber;
	}
	public int getNumberOfSongs() {
		return numberOfSongs;
	}
	public void setNumberOfSongs(int numberOfSongs) {
		this.numberOfSongs = numberOfSongs & 0xFF; // leaves only the least significant byte
	}
	public int getFirstSong() {
		return firstSong;
	}
	public void setFirstSong(int firstSong) {
		this.firstSong = firstSong & 0xFF;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(author, copyright, firstSong, numberOfSongs, title);
	}
	
	@Override
	public String toString() {
		return "GbsTag [identifier=" + header + ", versionNumber=" + versionNumber + ", numberOfSongs=" + numberOfSongs
				+ ", firstSong=" + firstSong + ", title=" + title + ", author=" + author + ", copyright=" + copyright
				+ "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GbsTag other = (GbsTag) obj;
		return Objects.equals(author, other.author) && Objects.equals(copyright, other.copyright)
				&& firstSong == other.firstSong && numberOfSongs == other.numberOfSongs
				&& Objects.equals(title, other.title);
	}
	
	@Override
	public int compareTo(GbsTag arg) {
		return gbsComparator.compare(this, arg);
	}
	
}
