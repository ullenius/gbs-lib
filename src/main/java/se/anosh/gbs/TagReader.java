package se.anosh.gbs;

import java.io.IOException;

import se.anosh.gbs.domain.LowLevel;
import se.anosh.gbs.domain.ReadOnlySimpleGbsTag;
import se.anosh.gbs.domain.SimpleGbsTag;
import se.anosh.gbs.domain.Tag;
import se.anosh.gbs.service.Gbs;
import se.anosh.gbs.service.GbsFile;

/**
 *
 * GBS tag library 0.1
 * 
 * Java library for reading the tags from Game Boy Sound (gbs) files.
 * 
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
public class TagReader {

	public static void main(String[] args) throws IOException {
		
		test();
		editTags();

	}
	
	/*
	 * Code from the docs
	 */
	static void test() throws IOException {
		
		Gbs gbsfile = new GbsFile("/tmp/supermarioland.gbs");
		Tag tag = gbsfile.getTag();
		
		printTags(tag);
		printLowLevel(tag);
		
		editTags();
		
	}
	
	static void editTags() throws IOException {
		Gbs anotherFile = new GbsFile("/tmp/metalgear2.gbs");
		SimpleGbsTag metalgear = anotherFile.getTag();
		metalgear.setAuthor("Norihiko Hibino, Kazuki Muraoka");
		anotherFile.save();
	}
	
	
	static void printTags(ReadOnlySimpleGbsTag tag) {
		System.out.println("Author:\t" + tag.getAuthor());
		System.out.println("Title:\t" + tag.getTitle());
		System.out.println("Copyright:\t" + tag.getCopyright());
	}
	
	
	static void printLowLevel(LowLevel tag) {
		System.out.println("The first one is no. " + tag.getFirstSong());
		System.out.println("Version number: " + tag.getVersionNumber());
		System.out.println("This gbs file contains: " + tag.getNumberOfSongs() + " songs");
	}
	
	

}
