package com.laamella.cc65plugin.ld65;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.laamella.cc65plugin.ca65.Ca65Language;
import com.laamella.cc65plugin.ca65.Ca65LexerAdapter;
import com.laamella.cc65plugin.ca65.Ca65Parser;
import com.laamella.cc65plugin.ca65.psi.Ca65File;
import com.laamella.cc65plugin.ca65.psi.Ca65Types;
import org.jetbrains.annotations.NotNull;

public class Ld65ParserDefinition implements ParserDefinition {
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(Ca65Types.COMMENT);

    public static final IFileElementType FILE = new IFileElementType(Ca65Language.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new Ca65LexerAdapter();
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.create(Ca65Types.STRING);
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new Ca65Parser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new Ca65File(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return Ca65Types.Factory.createElement(node);
    }
}
