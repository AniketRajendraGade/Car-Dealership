package com.project.Carss;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix="file")
@Data
public class FileStorageproperties {
	private String uploadDir;

}
