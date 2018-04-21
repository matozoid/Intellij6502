package com.laamella.intellij6502.asm;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AssemblyLexerTest {
    @Test
    public void aaa() throws IOException {
        String prog = "ab lda #15\n";
        assertLexed("label='ab' opcode='lda' hekje='#' number='15' eol='\\n'", prog);
    }

    @Test
    public void bbb() throws IOException {
        String prog = " ab lda #15\n";
        assertLexed("identifier='ab' opcode='lda' hekje='#' number='15' eol='\\n'", prog);
    }

    private void assertLexed(String expected, String prog) throws IOException {
        AssemblyLexer lexer = new AssemblyLexer(null);
        lexer.reset(prog, 0, prog.length(), 0);
        StringBuilder result = new StringBuilder();
        while (true) {
            IElementType elementType = lexer.advance();
            if (elementType == null) {
                break;
            }
            if(elementType.equals(TokenType.WHITE_SPACE)){
                continue;
            }
            String s = elementType.toString()
                    .replace("AssemblyTokenType.", "")
                    .toLowerCase()
                    + "='" + lexer.yytext().toString().replace("\n", "\\n") + "' ";
            result.append(s);
        }
        assertEquals(expected, result.toString().trim());
    }

}