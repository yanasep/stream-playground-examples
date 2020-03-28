import countries.*;

var countries = new Countries().getAll();

// 1. Returns the number of countries:

long numberOfCountries = countries.stream().count();

// 2. Prints country names in alphabetical order:

countries.stream().
  map(Country::getName).
  sorted().
  forEach(System.out::println);

// 3. Prints the capital of each country in alphabetical order:

countries.stream().
  map(Country::getCapital).
  sorted().
  forEach(System.out::println);

// 4. Prints the names of the first five countries:

countries.stream().
  map(Country::getName).
  limit(5).
  forEach(System.out::println);

// 5. Returns the maximum population:

long maxPopulation = countries.stream().
  mapToLong(Country::getPopulation).
  max().
  getAsLong();

// 6. Prints all countries with population below 100:

countries.stream().
  filter(country -> country.getPopulation() < 100).
  forEach(System.out::println);

// 7. Prints the names of countries with population below 100:

countries.stream().
  filter(country -> country.getPopulation() < 100).
  map(Country::getName).
  forEach(System.out::println);

// 8. Returns whether there is at least one country with 0 population:

countries.stream().anyMatch(country -> country.getPopulation() == 0);

// 9. Returns whether each country has at least one timezone:

countries.stream().allMatch(country -> ! country.getTimezones().isEmpty());
countries.stream().allMatch(country -> country.getTimezones().size() > 0);

// 10. Returns the first country whose name starts with ‘H’:

countries.stream().
  filter(country -> country.getName().charAt(0) == 'H').
  findFirst();

countries.stream().
  filter(country -> country.getName().startsWith("H")).
  findFirst();

// 11. Prints the names of European countries:

countries.stream().
  filter(country -> country.getRegion() == Region.EUROPE).
  map(Country::getName).
  forEach(System.out::println);

// 12. Returns the sum of population of European countries:

long populationTotal = countries.stream().
  filter(country -> country.getRegion() == Region.EUROPE).
  mapToLong(Country::getPopulation).
  sum();

// 13. Prints the population of European countries in ascending order:

countries.stream().
  filter(country -> country.getRegion() == Region.EUROPE).
  mapToLong(Country::getPopulation).
  sorted().
  forEach(System.out::println)

// 14. Prints the population of European countries in descending order:

countries.stream().
  filter(country -> country.getRegion() == Region.EUROPE).
  mapToLong(Country::getPopulation).
  boxed(). // returns a Stream of java.lang.Long objects (required because LongStream has only a no-argument sorted() operation)
  sorted(Comparator.reverseOrder()).
  forEach(System.out::println)

// 15. Returns the European country with the highest population:

Country mostPopulousCountry = countries.stream().
  filter(country -> country.getRegion() == Region.EUROPE).
  max(Comparator.comparingLong(Country::getPopulation)).
  get();

// 16. Returns the name of the European country with the highest population:

countries.stream().
  filter(country -> country.getRegion() == Region.EUROPE).
  max(Comparator.comparingLong(Country::getPopulation)).
  get().
  getName();

// 17. Returns the length of the longest country name:

String longestCountryName = countries.stream().
  map(Country::getName).
  max(Comparator.comparingInt(String::length)).
  get();

// 18. Returns the number of all distinct timezones:

long numberOfTimezones = countries.stream().
  flatMap(country -> country.getTimezones().stream()).
  distinct().
  count();

// 19. Prints all distinct timezones of European countries:

countries.stream().
  filter(country -> country.getRegion() == Region.EUROPE).
  flatMap(country -> country.getTimezones().stream()).
  distinct().
  forEach(System.out::println);

// 20. Returns the names of countries with 0 population in a list:

List<String> countryNames = countries.stream().
  filter(country -> country.getPopulation() == 0).
  map(Country::getName).
  collect(Collectors.toList());

