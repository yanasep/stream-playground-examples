Feladatok
=========

__Fontos__: a működéshez a JShell-t az `mvn jshell:run` paranccsal kell elindítani a [stream-playground](https://github.com/jeszy75/stream-playground/) projekt könyvtárában.

Az alábbi feladatok megoldásához a JShellben hajtsuk végre az alábbi kódrészeket:
```java
import countries.*;
var countries = new Countries().getAll();
```
A továbbiakban a `countries` változó értéke `Country` objektumok egy listája, ezt kell használni a megoldásokban.

Írj _stream_ csővezetéket, mely:

1. Visszaadja az országok számát.

1. A konzolra írja az egyes országok nevét.

1. A konzolra írja az egyes országok fővárosainak nevét ábécé sorrendben.

1. A konzolra írja az első 5 ország nevét (használandó köztes művelet: [`limit`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html#limit(long))).

1. Visszaadja az országok lélekszámának maximumát.

1. A konzolra írja a 100-nál kisebb lélekszámú országokat.

1. A konzolra írja a 100-nál kisebb lélekszámú országok neveit.

1. Visszaadja, hogy van-e legalább egy olyan ország, melynek 0 a lélekszáma (használandó terminális művelet: [`anyMatch`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html#anyMatch(java.util.function.Predicate))).

1. Visszaadja, hogy minden országhoz legalább egy időzóna tartozik-e (használandó terminális művelet: [`allMatch`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html#allMatch(java.util.function.Predicate))).

1. Visszaadja az első olyan országot, melynek a neve 'H' betűvel kezdődik (használandó terminális művelet: [`findFirst`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html#findFirst())).

1. A konzolra írja az európai országok neveit.

1. Visszaadja az európai országok lélekszámainak összegét.

1. A konzolra írja az európai országok lélekszámait növekvő sorrendben.

1. A konzolra írja az európai országok lélekszámait csökkenő sorrendben.

1. Visszaadja a legnagyobb lélekszámú európai országot.

1. Visszaadja a legnagyobb lélekszámú európai ország nevét.

1. Visszaadja, hogy hány karakterből áll a leghosszabb országnév.

1. Visszaadja az összes különböző időzóna számát (használandó köztes műveletek: [`flatMap`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html#flatMap(java.util.function.Function)), [`distinct`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html#distinct())).

1. A konzolra írja az európai országok összes különböző időzónáját (használandó köztes műveletek: [`flatMap`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html#flatMap(java.util.function.Function)), [`distinct`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html#distinct())).

1. Visszadja egy listában a 0 lélekszámú országok neveit.
