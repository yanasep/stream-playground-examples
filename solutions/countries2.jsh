import countries.*;
var countries = new Countries().getAll();

// 1. Returns whether there is at least one country with the word island in its name ignoring case.
countries.stream().
    anyMatch(c -> c.getName().toLowerCase().contains("island"));

// 2. Returns the first country name that contains the word island ignoring case.
countries.stream().
    filter(c -> c.getName().toLowerCase().contains("island")).
    findFirst().
    get().
    getName();

// 3. Prints each country name in which the first and the last letters are the same ignoring case.
countries.stream().
    filter(c -> c.getName().endsWith("" + Character.toLowerCase(c.getName().charAt(0)))).
    map(Country::getName).
    forEach(System.out::println);

// 4. Prints the populations of the first ten least populous countries (required intermediate operation: stream, limit)).
countries.stream().
    mapToLong(Country::getPopulation).
    boxed().
    sorted(Comparator.reverseOrder()).
    limit(10).
    forEach(System.out::println);

// 5. Prints the names of the first ten least populous countries (required intermediate operation: sorted, limit)).
countries.stream().
    sorted(Comparator.comparingLong(c -> -c.getPopulation())).
    limit(10).
    map(Country::getName).
    forEach(System.out::println);

// 6. Returns summary statistics about the number of country name translations associated with each country (required intermediate operation: mapToInt, summaryStatistics).
countries.stream().
    mapToInt(c -> c.getTranslations().size()).
    summaryStatistics();

// 7. Prints the names of countries in the ascending order of the number of timezones.
countries.stream().
    sorted(Comparator.comparingInt(c -> c.getTimezones().size())).map(Country::getName).
    forEach(System.out::println);

// 8. Prints the number of timezones for each country in the form name: population, in the ascending order of the number of timezones.
countries.stream().
    sorted(Comparator.comparingInt(c -> c.getTimezones().size())).
    map(c -> c.getName() + " : " + c.getTimezones().size()).
    forEach(System.out::println);

// 9. Returns the number of countries with no Spanish country name translation (the Spanish language is identified by the language code es).
countries.stream().
    filter(c -> !c.getTranslations().containsKey("es")).
    count();

// 10. Prints the names of countries with null area.
countries.stream().
    filter(c -> c.getArea() == null).
    map(Country::getName).
    forEach(System.out::println);

// 11. Prints all distinct language tags of country name translations sorted in alphabetical order (required intermediate operation: flatMap).
countries.stream().
    flatMap(c -> c.getTranslations().keySet().stream()).
    distinct().
    forEach(System.out::println);

// 12. Returns the average length of country names.
countries.stream().
    mapToInt(c -> c.getName().length()).
    average().
    getAsDouble();

// 13.Prints all distinct regions of the countries with null area.
countries.stream().
    filter(c -> c.getArea() == null).
    map(Country::getRegion).
    distinct().
    forEach(System.out::println);

// 14.Returns the largest country with non-null area.
countries.stream().
    filter(c -> c.getArea() != null).
    max(Comparator.comparing(Country::getArea));

// 15.Prints the names of countries with a non-null area below 10 (requires the use of BigDecimal.TEN).
countries.stream().
    filter(c -> c.getArea() != null && c.getArea().compareTo(BigDecimal.TEN) < 0).
    map(Country::getName).
    forEach(System.out::println);

// 16. Prints all distinct timezones of European and Asian countries.
countries.stream().
    filter(c -> c.getRegion() == Region.EUROPE || c.getRegion() == Region.ASIA).
    flatMap(c -> c.getTimezones().stream()).
    distinct().
    forEach(System.out::println);