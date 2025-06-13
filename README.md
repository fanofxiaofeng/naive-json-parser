# naive-json-parser
A naive parser for `JSON` string

Before diving into this project, let's think over several questions as follows
1. Is `"true"` a valid `JSON` string? What about `" \r\n\t true"`, `3.14`, `"\u0000"`, ...?
2. With `node.js`, `JSON.parse("123456789123456789123456789")` returns `1.2345678912345679e+26`, so does `JSON` format support arbitrary length integers?
3. With `node.js`, both `JSON.parse("\\/")` and `JSON.parse("/")` run successfully, does `JSON` format support both `"\\/"` and `"/"`?

I referred to [Introducing JSON](https://www.json.org/json-en.html)
and implemented a simple `JSON` parser.

## Usage

Step 1: Build a `jar` file with the following command
```bash
mvn clean package
```

Step 2: Use this `jar` file to parse and pretty print `JSON` string from standard input.
An example is shown below.
```
echo '  [   {"Message": "Hello, world", "Some special numbers": [4.2E1, 23E0,   3.14159265358979], "Today is Saturday" : true, "Needs to work": false, "Test for null": null}]' | \
  java -jar target/naive-json-parser-1.0-SNAPSHOT-jar-with-dependencies.jar
```
The output is like this
```json
[
    {
        "Message": "Hello, world",
        "Some special numbers": [
            4.2E1,
            23E0,
            3.14159265358979
        ],
        "Today is Saturday": true,
        "Needs to work": false,
        "Test for null": null
    }
]
```

## Code structure
Let's take a look at the `main` method in `com.study.Main` class
```java
public static void main(String[] args) throws IOException {
    try (InputStream inputStream = System.in) {
        byte[] bytes = inputStream.readAllBytes();
        String raw = new String(bytes, StandardCharsets.UTF_8);

        JsonParser jsonParser = new JsonParser();
        Json json = jsonParser.parse(new PeekingIterator<>(raw.codePoints().iterator()));

        PresenterFacade presenterFacade = new PresenterFacade();
        String result = presenterFacade.convertToString(json);
        System.out.println(result);
    }
}
```

There are 3 steps.
1. Read from `stdin`
2. Parse as a `Json` instance
3. Present this `Json` instance


A `JSON` value can be any of the below items
* _object_
* _array_
* _string_
* _number_
* _"true"_ (i.e. literal `true`)
* _"false"_ (i.e. literal `false`)
* _"null"_ (i.e. literal `null`)

### Case 1: `null/false/true`
For `null`, `false`, `true`, they are special literal items.
They are parsed by the below parsers respectively 
1. [CaseNullParser](src/main/java/com/study/parser/CaseNullParser.java)
2. [CaseFalseParser](src/main/java/com/study/parser/CaseFalseParser.java)
3. [CaseTrueParser](src/main/java/com/study/parser/CaseTrueParser.java)

### Case 2: `number`
A `number` has below three parts
1. `integer`
2. `fraction`
3. `exponent`

`Number` items are parsed by [NumberParser](src/main/java/com/study/parser/NumberParser.java).

### Case 3: `string`
A `string` is composed by below three parts.
1. A leading `"`
2. `characters`
3. A tailing `"`

`String` items are parsed by [StringParser](src/main/java/com/study/parser/StringParser.java).

**TO BE CONTINUED**

TODO
* Use slf4j