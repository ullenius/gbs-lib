package se.anosh.gbs.service;

import java.io.IOException;

import se.anosh.gbs.domain.GbsTag;

public interface Gbs {

	GbsTag getTag();

	void save() throws IOException;

	String getFileName();

}