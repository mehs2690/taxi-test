package com.mehs.dev.taxitest.infra;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring")
public class SpringProperties {
	// TODOimplementar la lectura de los spring properties en caso de que no jale
}
