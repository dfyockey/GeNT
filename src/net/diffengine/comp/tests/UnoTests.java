package net.diffengine.comp.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import net.diffengine.comp.tests.base.UnoSuite;
import net.diffengine.comp.tests.uno.WriterTest;

@RunWith(UnoSuite.class)
@SuiteClasses({WriterTest.class})
public class UnoTests {

}
