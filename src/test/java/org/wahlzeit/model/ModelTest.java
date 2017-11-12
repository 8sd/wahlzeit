package org.wahlzeit.model;

import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        org.wahlzeit.model.persistence.PersistenceTest.class,
        org.wahlzeit.model.AccessRightsTest.class,
        org.wahlzeit.model.FlagReasonTest.class,
        org.wahlzeit.model.GenderTest.class,
        org.wahlzeit.model.GuestTest.class,
        org.wahlzeit.model.LocationTest.class,
        org.wahlzeit.model.PhotoFilterTest.class,
        org.wahlzeit.model.TagsTest.class,
        org.wahlzeit.model.UserStatusTest.class,
        org.wahlzeit.model.ValueTest.class,
        org.wahlzeit.model.BeerPhotoTest.class,
        org.wahlzeit.model.BeerPhotoManagerTest.class,
        org.wahlzeit.model.BeerPhotoFactoryTest.class
})

public class ModelTest {
}
