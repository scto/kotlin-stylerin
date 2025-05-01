package com.levelrin;

import com.levelrin.antlr.generated.KotlinLexer;
import com.levelrin.antlr.generated.KotlinParser;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

final class KotlinVisitorTest {

    /**
     * Assert that the formatter formats the code written in the `before` file that matches with the code written in the `after` file.
     *
     * @param before The file name that has code before formatting.
     * @param after The file name that has code after formatting.
     */
    void compare(final String before, final String after) {
        try {
            final Path beforePath = Paths.get(ClassLoader.getSystemResource(before).toURI());
            final String originalText = Files.readString(beforePath, StandardCharsets.UTF_8);
            final CharStream charStream = CharStreams.fromString(originalText);
            final KotlinLexer lexer = new KotlinLexer(charStream);
            final CommonTokenStream tokens = new CommonTokenStream(lexer);
            final KotlinParser parser = new KotlinParser(tokens);
            final ParseTree tree = parser.kotlinFile();
            final KotlinVisitor visitor = new KotlinVisitor(tokens);
            final String result = visitor.visit(tree);
            final Path afterPath = Paths.get(ClassLoader.getSystemResource(after).toURI());
            final String expectedText = Files.readString(afterPath, StandardCharsets.UTF_8);
            MatcherAssert.assertThat(
                String.format("Result:%n%s", result),
                result,
                Matchers.equalTo(expectedText)
            );
        } catch (final URISyntaxException | IOException ex) {
            throw new IllegalStateException(
                String.format(
                    "Failed to read files. before: %s, after: %s",
                    before,
                    after
                ),
                ex
            );
        }
    }

    @Test
    void shouldFormatPrefixUnaryOperation() {
        this.compare("prefix-unary-operation-before.kt", "prefix-unary-operation-after.kt");
    }

    @Test
    void shouldFormatCallSuffix() {
        this.compare("call-suffix-before.kt", "call-suffix-after.kt");
    }

    @Test
    void shouldFormatAnnotatedLambda() {
        this.compare("annotated-lambda-before.kt", "annotated-lambda-after.kt");
    }

    @Test
    void shouldFormatSecondaryConstructor() {
        this.compare("secondary-constructor-before.kt", "secondary-constructor-after.kt");
    }

    @Test
    void shouldFormatPostfixUnaryOperations() {
        this.compare("postfix-unary-operation-before.kt", "postfix-unary-operation-after.kt");
    }

    @Test
    void shouldFormatWhenConditions() {
        this.compare("when-condition-before.kt", "when-condition-after.kt");
    }

    @Test
    void shouldFormatMultiLineStringLiterals() {
        this.compare("multi-line-string-literal-before.kt", "multi-line-string-literal-after.kt");
    }

    @Test
    void shouldFormatStringLiterals() {
        this.compare("string-literal-before.kt", "string-literal-after.kt");
    }

    @Test
    void shouldFormatTypeProjections() {
        this.compare("type-projection-before.kt", "type-projection-after.kt");
    }

    @Test
    void shouldFormatDelegationSpecifiers() {
        this.compare("delegation-specifiers-before.kt", "delegation-specifiers-after.kt");
    }

    @Test
    void shouldFormatEnumEntry() {
        this.compare("enum-entry-before.kt", "enum-entry-after.kt");
    }

    @Test
    void shouldFormatObjectDeclarations() {
        this.compare("object-declaration-before.kt", "object-declaration-after.kt");
    }

    @Test
    void shouldFormatClassMemberDeclarations() {
        this.compare("class-member-declaration-before.kt", "class-member-declaration-after.kt");
    }

    @Test
    void shouldFormatTopLevelObjects() {
        this.compare("top-level-object-before.kt", "top-level-object-after.kt");
    }

    @Test
    void shouldFormatPrivateConstructor() {
        this.compare("private-constructor-before.kt", "private-constructor-after.kt");
    }

    @Test
    void shouldFormatConjunction() {
        this.compare("conjunction-before.kt", "conjunction-after.kt");
    }

    @Test
    void shouldFormatFileAnnotations() {
        this.compare("file-annotation-before.kt", "file-annotation-after.kt");
    }

    @Test
    void shouldFormatAnonymousObject() {
        this.compare("anonymous-object-before.kt", "anonymous-object-after.kt");
    }

    @Test
    void shouldFormatUserType() {
        this.compare("user-type-before.kt", "user-type-after.kt");
    }

    @Test
    void shouldFormatDeclarations() {
        this.compare("declaration-before.kt", "declaration-after.kt");
    }

    @Test
    void shouldFormatDisjunction() {
        this.compare("disjunction-before.kt", "disjunction-after.kt");
    }

    @Test
    void shouldFormatElvisOperator() {
        this.compare("elvis-before.kt", "elvis-after.kt");
    }

    @Test
    void shouldFormatAtomicExpression() {
        this.compare("atomic-expression-before.kt", "atomic-expression-after.kt");
    }

    @Test
    void shouldFormatPrefixUnaryExpression() {
        this.compare("prefix-unary-expression-before.kt", "prefix-unary-expression-after.kt");
    }

    @Test
    void shouldFormatZip() {
        this.compare("zip-before.kt", "zip-after.kt");
    }

    @Test
    void shouldFormatAnnotations() {
        this.compare("annotation-before.kt", "annotation-after.kt");
    }

    @Test
    void shouldFormatInitializers() {
        this.compare("init-before.kt", "init-after.kt");
    }

    @Test
    void shouldFormatComments() {
        this.compare("comment-before.kt", "comment-after.kt");
    }

    @Test
    void shouldFormatGettersAndSetters() {
        this.compare("getters-setters-before.kt", "getters-setters-after.kt");
    }

    @Test
    void shouldFormatGeneric() {
        this.compare("generic-before.kt", "generic-after.kt");
    }

    @Test
    void shouldFormatTailRecursiveFunctions() {
        this.compare("tailrec-before.kt", "tailrec-after.kt");
    }

    @Test
    void shouldFormatNamedParameters() {
        this.compare("named-params-before.kt", "named-params-after.kt");
    }

    @Test
    void shouldFormatDestructure() {
        this.compare("destructure-before.kt", "destructure-after.kt");
    }

    @Test
    void shouldFormatMap() {
        this.compare("map-before.kt", "map-after.kt");
    }

    @Test
    void shouldFormatMethodChain() {
        this.compare("method-chain-before.kt", "method-chain-after.kt");
    }

    @Test
    void shouldFormatComposition() {
        this.compare("composition-before.kt", "composition-after.kt");
    }

    @Test
    void shouldFormatTypeCast() {
        this.compare("type-cast-before.kt", "type-cast-after.kt");
    }

    @Test
    void shouldFormatException() {
        this.compare("exception-before.kt", "exception-after.kt");
    }

    @Test
    void shouldFormatLambda() {
        this.compare("lambda-before.kt", "lambda-after.kt");
    }

    @Test
    void shouldFormatExtensions() {
        this.compare("extension-before.kt", "extension-after.kt");
    }

    @Test
    void shouldFormatObjects() {
        this.compare("object-before.kt", "object-after.kt");
    }

    @Test
    void shouldFormatDelegatedProperties() {
        this.compare("delegated-properties-before.kt", "delegated-properties-after.kt");
    }

    @Test
    void shouldFormatTypeAlias() {
        this.compare("type-alias-before.kt", "type-alias-after.kt");
    }

    @Test
    void shouldFormatDelegation() {
        this.compare("delegation-before.kt", "delegation-after.kt");
    }

    @Test
    void shouldFormatSealedClass() {
        this.compare("sealed-class-before.kt", "sealed-class-after.kt");
    }

    @Test
    void shouldFormatDataClass() {
        this.compare("data-class-before.kt", "data-class-after.kt");
    }

    @Test
    void shouldFormatEnum() {
        this.compare("enum-before.kt", "enum-after.kt");
    }

    @Test
    void shouldFormatConstructor() {
        this.compare("constructor-before.kt", "constructor-after.kt");
    }

    @Test
    void shouldFormatInterface() {
        this.compare("interface-before.kt", "interface-after.kt");
    }

    @Test
    void shouldFormatInheritance() {
        this.compare("inheritance-before.kt", "inheritance-after.kt");
    }

    @Test
    void shouldFormatClasses() {
        this.compare("class-before.kt", "class-after.kt");
    }

    @Test
    void shouldFormatVariables() {
        this.compare("variable-before.kt", "variable-after.kt");
    }

    @Test
    void shouldFormatFunctions() {
        this.compare("function-before.kt", "function-after.kt");
    }

    @Test
    void shouldFormatImportStatements() {
        this.compare("import-before.kt", "import-after.kt");
    }

    @Test
    void shouldFormatWhenStatements() {
        this.compare("when-before.kt", "when-after.kt");
    }

    @Test
    void shouldFormatDoWhileLoop() {
        this.compare("do-while-before.kt", "do-while-after.kt");
    }

    @Test
    void shouldFormatWhileLoop() {
        this.compare("while-before.kt", "while-after.kt");
    }

    @Test
    void shouldFormatForLoop() {
        this.compare("for-before.kt", "for-after.kt");
    }

    @Test
    void shouldFormatIfStatements() {
        this.compare("if-before.kt", "if-after.kt");
    }

    @Test
    void shouldFormatMain() {
        this.compare("main-before.kt", "main-after.kt");
    }

}
