package com.laamella.intellij6502.asm;

import com.intellij.testFramework.ParsingTestCase;

public class AssemblyParsingTest extends ParsingTestCase {
  public AssemblyParsingTest() {
    super("", "asm", new AssemblyParserDefinition());
  }

  public void testParsingTestData() {
    doTest(true);
  }

  @Override
  protected String getTestDataPath() {
    return "src/test/resources/code_samples/asm";
  }

  @Override
  protected boolean skipSpaces() {
    return true;
  }

  @Override
  protected boolean includeRanges() {
    return true;
  }
}
