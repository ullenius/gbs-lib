package se.anosh.gbstag.service;

import java.io.IOException;

import se.anosh.gbstag.domain.GbsTag;

public interface Gbs {

	GbsTag getTag();

	void save() throws IOException;

	String getFileName();

}