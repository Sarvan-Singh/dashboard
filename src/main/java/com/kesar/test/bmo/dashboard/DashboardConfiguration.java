package com.kesar.test.bmo.dashboard;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author Kesar.Singh
 *	class to enable application level configurations
 */
// Remove "exlucde"s from @EnableAutoConfiguration once DataSource is provided.

@Configuration
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
// @EnableSpringDataWebSupport
// @EnableJpaRepositories
public class DashboardConfiguration {

}
