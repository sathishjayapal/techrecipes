package org.techrecipes.online.streams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration()
@ComponentScan("org/techrecipes/online/streams")
public class StreamsConfig {

  public static final Logger LOG = LoggerFactory.getLogger(StreamsConfig.class);
  @Autowired
  StreamsFilterSample streamFilterStream;
  @Autowired
  StreamsFilterSample streamsFilterSample;

  public StreamsConfig() {
    LOG.debug("Debugging method start ==> StreamsConfig " + "with parameter []");
    System.out.println("Constructed");
    LOG.debug("Debugging method end ==> StreamsConfig " + "with parameter []");
  }
}
