# Kase
[![](https://img.shields.io/badge/language-Kotlin-orange.svg)](https://kotlinlang.org)
[![](https://api.travis-ci.org/blackbracken/Kase.svg?branch=master)](https://travis-ci.org/blackbracken/Kase)
[![](https://jitpack.io/v/blackbracken/Kase.svg)](https://jitpack.io/#blackbracken/Kase)

## 概要
ミニマルなDataHolderのライブラリです.

一つのデータに含まれる複数個のデータを一対多の関係にラップして, Keyを用いることで柔軟かつ容易に操作させることを目標としています.

## 使い方
* `SourceContainer<S : Any>`は"複数個のデータを持つ一つのデータを含むもの"に対応します.
* `Kase<C : SourceContainer<S>, S: Any>`は`SourceContainer`を包含し, `Key`以外からはソースとなるデータを隠します.
* `Key<in C : SourceContainer<S>, S : Any, out V : Any>`は`Kase`に用いることで, 目的する操作(`get`)を達成します.
  * `Key`を継承した`WritableKey< .. >`を用いることで, 書き込み(`set`)も可能になります.

### 例
```kotlin
data class Json(private var rawJson: String) {
    operator fun get(key: String): Any? = TODO("implemented")
    operator fun set(key: String, value: String): Unit = TODO("implemented")
}

private val A_KEY = SimpleKey<SourceContainer<Json>, Json, String> { container -> container.source["A"] as? A }
private val B_KEY = SimpleWritableKey<SourceContainer<Json>, Json, String>(
    extractor = { container -> container.source["B"] as? B },
    inserter = { container, value -> container.source["B"] = value }
)

fun main() {
    val json: Json = TODO("initialized")
    val container = SimpleSourceContainer(json)
    val kase = SimpleKase(container)

    val a = kase[A_KEY] ?: TODO("if not exists")
    val b = kase.getOrPut(B_KEY) { TODO("new B") }
    
    kase[B_KEY] = "NEW B!"
    
    // ...
}
```

## 環境
* Kotlin 1.3.11

## リポジトリ
* Gradle
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.blackbracken:Kase:<VERSION>'
}
```

* Maven
```xml
<!-- add JitPack repository -->
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<!-- add the dependency -->
<dependency>
    <groupId>com.github.blackbracken</groupId>
    <artifactId>Kase</artifactId>
    <version>VERSION</version>
</dependency>
```