package info.yalamanchili.office.server.config;

import info.yalamanchili.office.config.OfficeWebConfiguration;
import info.yalamanchili.office.server.FileServiceImpl;
import info.yalamanchili.office.server.HttpServiceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;

@Configuration
public class OfficeSpringConfiguration {

    @Bean
    public HttpServiceImpl httpServiceImpl() {
        return new HttpServiceImpl();
    }

    @Bean
    public OfficeWebSpringContext officeWebSpringContext() {
        return new OfficeWebSpringContext();
    }

    @Bean
    public OfficeWebConfiguration officeWebConfiguration() {
        return new OfficeWebConfiguration();
    }

    @Bean
    public MBeanExporter createJmxExporter() {
        Map<String, Object> mbeans = new HashMap<String, Object>();
        mbeans.put("bean:name=OfficeWebConfiguration", officeWebConfiguration());
        MBeanExporter mBeanExporter = new MBeanExporter();
        mBeanExporter.setAllowEagerInit(true);
        mBeanExporter.setBeans(mbeans);
        return mBeanExporter;
    }

    @Bean
    public RmiRegistryFactoryBean rmiRegistryFactoryBean() {
        RmiRegistryFactoryBean rmiRegistryFactoryBean = new RmiRegistryFactoryBean();
        rmiRegistryFactoryBean.setPort(10098);
        return rmiRegistryFactoryBean;
    }

    @Bean
    public ConnectorServerFactoryBean connectorServerFactoryBean() {
        ConnectorServerFactoryBean connectorServerFactoryBean = new ConnectorServerFactoryBean();
        try {
            connectorServerFactoryBean.setObjectName("connector:name=office-web-rmi");
            connectorServerFactoryBean
                    .setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:10098/office-web-connector");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connectorServerFactoryBean;
    }
}
