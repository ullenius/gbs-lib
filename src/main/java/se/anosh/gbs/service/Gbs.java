package se.anosh.gbs.service;

import java.io.IOException;

import se.anosh.gbs.domain.Tag;

public interface Gbs {

	Tag getTag();

	void save() throws IOException;
	String getFileName();

}