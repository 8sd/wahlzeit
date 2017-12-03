package org.wahlzeit.services;

import org.junit.runner.*;
import org.junit.runners.*;
import org.wahlzeit.services.mailing.MailingTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MailingTestSuite.class,
        EmailAddressTest.class,
        LogBuilderTest.class
        })

public class ServiceTestSuite {
}
