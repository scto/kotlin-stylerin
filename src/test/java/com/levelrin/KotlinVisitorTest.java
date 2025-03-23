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
            final KotlinVisitor visitor = new KotlinVisitor();
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
