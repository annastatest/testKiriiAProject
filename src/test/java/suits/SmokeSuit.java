package suits;

import calc_subsidiesTest.Calc_subsidiesTest;
import loginTest.AuthorizationValid_Test;
import loginTest.EditUserSettingsTest;
import objectsTest.AddNewObjectTest;
import objectsTest.AddNewObjectWithInvalidAuthKeyTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pages.Calc_subsidiesPage;
import pages.EditUserSettingsPage;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                AuthorizationValid_Test.class,
                EditUserSettingsTest.class,
                AddNewObjectTest.class,
                AddNewObjectWithInvalidAuthKeyTest.class,
                Calc_subsidiesTest.class
        }
)

public class SmokeSuit {
}
