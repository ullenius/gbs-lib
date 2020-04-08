package se.anosh.gbstag;

import java.io.IOException;

import se.anosh.gbstag.domain.GbsTag;
import se.anosh.gbstag.service.Gbs;
import se.anosh.gbstag.service.GbsFile;

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


		Gbs wario = new GbsFile("/tmp/wario.gbs");
		
		GbsTag tag = wario.getTag();

		System.out.println(tag);
		
//		tag.setAuthor("hej");
//		wario.save();
		
		

	}

}
