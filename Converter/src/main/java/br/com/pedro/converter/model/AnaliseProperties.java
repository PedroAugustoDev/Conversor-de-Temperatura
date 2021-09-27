package br.com.pedro.converter.model;

import br.com.pedro.converter.Main;
import java.io.IOException;
import java.util.Properties;

public class AnaliseProperties {
    private Properties properties;

    public AnaliseProperties() {
        try {
            this.properties = loadProperties();
        } catch ( IOException ignored ){

        }
    }

    private static Properties loadProperties() throws IOException {
        final Properties props = new Properties();
        props.load(Main.class.getResourceAsStream("application.properties"));
        return props;
    }

    public Object findAnotherValueFromKey( String key ) {
      if(properties.containsKey(key)) return this.properties.get(key);
      else return null;
    }

    public Object setValueByKey( String key, String value ){
        return properties.setProperty( key, value );
    }

    public boolean isEmpty(){
        return this.properties.isEmpty();
    }
}
