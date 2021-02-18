package by.epam.task03.reader.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.task03.exception.ShapeException;
import by.epam.task03.reader.CommonReader;

public class DataReaderImpl implements CommonReader {
	public static Logger logger = LogManager.getLogger();

	@Override
	public List<String> readAll(String filePath) throws ShapeException {
		if (filePath == null) {
			throw new ShapeException("filePath is null");
		}
		Path path = Paths.get(filePath);
		List<String> data;
		try (Stream<String> streamLines = Files.lines(path)) {
			data = streamLines.collect(Collectors.toList());
		} catch (IOException e) {
			logger.log(Level.ERROR, "file " + filePath + " not found", e);
			throw new ShapeException("file " + filePath + " not found", e);	
		}
		logger.log(Level.INFO, "read data from file : " + data);
		return data;
	}
}
