package org.wahlzeit;

import org.junit.runner.*;
import org.junit.runners.*;
import org.wahlzeit.handlers.HandlersTestSuite;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.services.ServiceTestSuite;
import org.wahlzeit.utils.UtilsTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        HandlersTestSuite.class,
        ModelTestSuite.class,
        ServiceTestSuite.class,
        UtilsTestSuite.class,
        })

public class AllTestSuite {
}
