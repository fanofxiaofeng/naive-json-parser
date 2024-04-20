# naive-json-parser
A naive parser for `json` string

I referred to [Introducing JSON](https://www.json.org/json-en.html)
and implemented a very simple `json` parser.

## Usage

Step 1: Build a `jar` file with the following command
```bash
mvn clean package
```

Step 2: Use this `jar` file to parse and pretty print json string from standard input.
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
```

There are 3 main steps.
1. Read from stdin
2. Parse to a `Json` instance
3. Present this `Json` instance



todo