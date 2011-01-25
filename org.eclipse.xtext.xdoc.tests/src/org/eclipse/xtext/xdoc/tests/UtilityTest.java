package org.eclipse.xtext.xdoc.tests;

import java.util.Arrays;

import org.eclipse.xtext.xdoc.xdoc.Code;
import org.eclipse.xtext.xdoc.xdoc.CodeBlock;
import org.eclipse.xtext.xdoc.xdoc.LangDef;
import org.eclipse.xtext.xdoc.xdoc.XdocFactory;

import templates.util.StringFormatter;
import junit.framework.TestCase;

public class UtilityTest extends TestCase {

	String testStringSplitting =
	"&nbsp;grammar&nbsp;org.eclipse.xtext.common.Terminals&nbsp;<br />\n" +
	"&nbsp;hidden(WS,&nbsp;ML_COMMENT,&nbsp;SL_COMMENT)<br />\n" +
	"import&nbsp;\"http://www.eclipse.org/emf/2002/Ecore\"&nbsp;as&nbsp;ecore<br />\n" +
	"terminal&nbsp;ID&nbsp;:&nbsp;<br />\n" +
	"&nbsp;&apos;^&apos;?(&apos;a&apos;..&apos;z&apos;|&apos;A&apos;..&apos;Z&apos;|&apos;_&apos;)&nbsp;(&apos;a&apos;..&apos;z&apos;|&apos;A&apos;..&apos;Z&apos;|&apos;_&apos;|&apos;0&apos;..&apos;9&apos;)*&nbsp;;<br />\n" +
	"terminal&nbsp;INT&nbsp;returns&nbsp;ecore::EInt:&nbsp;(&apos;0&apos;..&apos;9&apos;)+&nbsp;;<br />\n" +
	"terminal&nbsp;STRING&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;<br />\n" +
	"&nbsp;&apos;\"&apos;&nbsp;(&nbsp;&apos;\\\\&apos;&nbsp;(&apos;b&apos;|&apos;t&apos;|&apos;n&apos;|&apos;f&apos;|&apos;r&apos;|&apos;\"&apos;|\"&apos;\"|&apos;\\\\&apos;)&nbsp;|&nbsp;!(&apos;\\&apos;|&apos;\"&apos;)&nbsp;)*&nbsp;&apos;\"&apos;&nbsp;|<br />\n" +
	"&nbsp;\"&apos;\"&nbsp;(&nbsp;&apos;\\\\&apos;&nbsp;(&apos;b&apos;|&apos;t&apos;|&apos;n&apos;|&apos;f&apos;|&apos;r&apos;|&apos;\"&apos;|\"&apos;\"|&apos;\\\\&apos;)&nbsp;|&nbsp;!(&apos;\\\\&apos;|\"&apos;\")&nbsp;)*&nbsp;\"&apos;\";&nbsp;<br />\n" +
	"terminal&nbsp;ML_COMMENT&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&apos;/*&apos;&nbsp;-&gt;&nbsp;&apos;*/&apos;&nbsp;;<br />\n" +
	"terminal&nbsp;SL_COMMENT&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&apos;//&apos;&nbsp;!(&apos;\\n&apos;|&apos;\\r&apos;)*&nbsp;(&apos;\\r&apos;?&nbsp;&apos;\\n&apos;)?&nbsp;;<br />\n" +
	"terminal&nbsp;WS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;(&apos;&nbsp;&apos;|&apos;\\t&apos;|&apos\\;\\r&apos;|&apos;\\n&apos;)+&nbsp;;<br />\n" +
	"terminal&nbsp;ANY_OTHER:&nbsp;&nbsp;&nbsp;&nbsp;.&nbsp;;";

	private LangDef testLangDef;

	private String[] testKeyWords = {"grammar", "with", "import", "terminal", "returns", };

	private String testCodeString =	"\tclass Foo{\n"+
									"\t\tstatic int foo = 13;\n" +
									"\t}\t\n\n  ";

	private String expectationCodeString = "class Foo{\n\tstatic int foo = 13;\n}";

	private CodeBlock testCodeBlock;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		this.testLangDef = XdocFactory.eINSTANCE.createLangDef();
		testLangDef.getKeywords().addAll(Arrays.asList(testKeyWords));

		this.testCodeBlock = XdocFactory.eINSTANCE.createCodeBlock();
		Code testCode = XdocFactory.eINSTANCE.createCode();
		testCode.setContents(testCodeString);
		testCodeBlock.getContents().add(testCode);
	}

	public void testSplitting() throws Exception {
		String text = testStringSplitting;
		String[] toks;
		do {
			toks = StringFormatter.splitToNext(text);
			if(toks.length == 3){
				assertFalse("infinite loop: " + toks[2] + " == " + text, toks[2].equals(text));
				text = toks[2];
			}
		} while(toks.length == 3);
	}

	public void testRemoveIndent() throws Exception {
		CodeBlock result = StringFormatter.removeIndent(this.testCodeBlock);
		assertEquals(1, result.getContents().size());
		assertTrue(result.getContents().get(0) instanceof Code);
		Code resultCode = (Code) result.getContents().get(0);
		assertEquals(expectationCodeString, resultCode.getContents());
	}
}
