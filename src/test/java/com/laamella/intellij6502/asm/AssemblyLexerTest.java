package com.laamella.intellij6502.asm;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AssemblyLexerTest {
    @Test
    public void aaa() throws IOException {
        String prog = "ab lda 1\nab lda 2\n";
        assertLexed("identifier='ab' opcode='lda' number='1' eol='\\n' identifier='ab' opcode='lda' number='2' eol='\\n'", prog);
    }
    @Test
    public void ccc() throws IOException {
        String prog = "lda #15\nlda #15\n";
        assertLexed("opcode='lda' hekje='#' number='15' eol='\\n' opcode='lda' hekje='#' number='15' eol='\\n'", prog);
    }

    @Test
    public void bbb() throws IOException {
        String prog = " ab lda 1\n ab lda 1\n";
        assertLexed("identifier='ab' opcode='lda' number='1' eol='\\n' identifier='ab' opcode='lda' number='1' eol='\\n'", prog);
    }

    @Test
    public void ddd() throws IOException {
        String prog = "lda 1";
        assertLexed("opcode='lda' number='1'", prog);
    }

    @Test
    public void eee() throws IOException {
        String prog = "ldx #size(zpcode)-1";
        assertLexed("opcode='ldx' hekje='#' identifier='size' open_paren='(' identifier='zpcode' close_paren=')' minus='-' number='1'", prog);
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