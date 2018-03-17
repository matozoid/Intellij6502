package com.laamella.cc65plugin;

import com.intellij.lang.*;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.tree.*;
import com.laamella.cc65plugin.psi.Ca65File;
import com.laamella.cc65plugin.psi.Ca65Types;
import org.jetbrains.annotations.NotNull;

public class Ca65ParserDefinition implements ParserDefinition {
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