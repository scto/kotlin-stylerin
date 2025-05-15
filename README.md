[![Build](https://github.com/levelrin/kotlin-stylerin/actions/workflows/build.yml/badge.svg?branch=main)](https://github.com/levelrin/kotlin-stylerin/actions/workflows/build.yml?query=branch%3Amain)
[![codecov](https://codecov.io/gh/levelrin/kotlin-stylerin/graph/badge.svg?token=noW3yHdtQq)](https://codecov.io/gh/levelrin/kotlin-stylerin)
[![](https://tokei.rs/b1/github/levelrin/kotlin-stylerin?category=code)](https://github.com/levelrin/kotlin-stylerin)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/levelrin/kotlin-stylerin/blob/main/LICENSE)

## About

It's a code formatter for [Kotlin](https://kotlinlang.org/).

Yes, we already have a formatter, such as [ktfmt](https://facebook.github.io/ktfmt/), but it's not good enough.

For example, we have the following code:
```kt
fun main() {
  val doll = RussianDoll("Rin",RussianDoll("Revomin",RussianDoll("Ian")))
  doll.unwrap()
}
class RussianDoll(private val name: String, private val child: RussianDoll? = null) {
    fun child(): RussianDoll? {return child}
    fun unwrap() {
        println(name)
        child?.unwrap()
    }
}
```

`ktfmt` formats the code like this by default:
```kt
fun main() {
  val doll = RussianDoll("Rin", RussianDoll("Revomin", RussianDoll("Ian")))
  doll.unwrap()
}
```

Our formatter formats the code like this:
```kt
fun main() {
  val doll = RussianDoll(
      "Rin",
      RussianDoll(
          "Revomin",
          RussianDoll("Ian")
      )
  )
  doll.unwrap()
}
```

Our format shows the composition better.

## Quick Start

Please install Java 11+ if you haven't already.

1. [Download](https://github.com/levelrin/kotlin-stylerin/releases) the zip file that matches with your Java version and unzip it to get the jar file.
2. Run the command `java -jar kotlin-stylerin-{app-version}-{java-version}.jar path/to/target.kt`

## Command Options

```
usage: java -jar kotlin-stylerin-{app-version}-{java-version}.jar [options]
 -h,--help              Show help messages.
 -q,--quiet             Do not print debug logs.
 -r,--recursive <arg>   Format files in the directory recursively.
 -v,--version           Print the version.
```

## Disclaimer

Not all [grammar rules](https://github.com/antlr/grammars-v4/blob/master/kotlin/kotlin/KotlinParser.g4) are supported yet.

Please always be ready to recover the file and use our formatter at your own risk.

If you find a bug or have a suggestion, please create a new [issue](https://github.com/levelrin/kotlin-stylerin/issues).
