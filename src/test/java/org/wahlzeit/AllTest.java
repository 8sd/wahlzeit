package org.wahlzeit;

import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        org.wahlzeit.handlers.HandlersTest.class,
        org.wahlzeit.model.ModelTest.class,
        org.wahlzeit.services.ServiceTest.class,
        org.wahlzeit.utils.UtilsTest.class,
        })

public class AllTest {
}
