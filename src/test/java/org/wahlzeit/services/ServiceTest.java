package org.wahlzeit.services;

import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        org.wahlzeit.services.mailing.MailingTest.class,
        org.wahlzeit.services.EmailAddressTest.class,
        org.wahlzeit.services.LogBuilderTest.class,
        })

public class ServiceTest {
}
