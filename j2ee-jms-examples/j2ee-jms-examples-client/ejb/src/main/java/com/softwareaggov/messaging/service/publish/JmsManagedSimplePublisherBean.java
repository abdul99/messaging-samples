package com.softwareaggov.messaging.service.publish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;

/**
 * Created by fabien.sanglier on 6/28/16.
 */

@Stateless(mappedName = "JmsManagedSimplePublisherBean")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(JmsPublisherLocal.class)
public class JmsManagedSimplePublisherBean extends JmsPublisherBaseBean {
    private static Logger log = LoggerFactory.getLogger(JmsManagedSimplePublisherBean.class);

    @Resource(name = "jms/someManagedCF")
    private ConnectionFactory jmsConnectionFactory;

    @Resource(name = "jms/someManagedSimpleDestination")
    private Destination jmsDestination;

    @Override
    public ConnectionFactory getJmsConnectionFactory() {
        return jmsConnectionFactory;
    }

    @Override
    public Destination getJmsDestination() {
        return jmsDestination;
    }
}
