package minierp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.ldap.LdapProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


//@EnableConfigurationProperties(value = {LdapProperties.class})
@SpringBootApplication
public class MiniErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniErpApplication.class, args);
	}

}
