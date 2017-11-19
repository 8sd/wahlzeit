package org.wahlzeit.model;

import org.junit.runner.*;
import org.junit.runners.*;
import org.wahlzeit.model.persistence.PersistenceTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PersistenceTestSuite.class,
        AccessRightsTest.class,
        FlagReasonTest.class,
        GenderTest.class,
        GuestTest.class,
        LocationTest.class,
        PhotoFilterTest.class,
        TagsTest.class,
        UserStatusTest.class,
        ValueTest.class,
        BeerPhotoTest.class,
        BeerPhotoManagerTest.class,
        BeerPhotoFactoryTest.class
})

public class ModelTestSuite {
}
