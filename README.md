### codeTest_movie_analyzer
# Java code test to implement a movie analyzer - Januray 2023




# Find top favorited movies among friends

Implement `MoviesAnalyzer#topFavouriteMoviesAmongFriends` method that will return an array of **top three** movie titles, that have been most favourited by friends of a given user.

If there are no such movies, then an empty list should be returned or as many movies as possible.

Movies that have equal favourite count, should be ordered alphabetically.

## Example data

### Movies collection:

  {
    "title": "The Shawshank Redemption",
    "duration": "PT142M",
    "actors": [ "Tim Robbins", "Morgan Freeman", "Bob Gunton" ],
    "ratings": [],
    "favorites": [66380, 7001, 9250, 34139],
    "watchlist": [15291, 51417, 62289, 6146, 71389, 93707]
  },
  {
    "title": "The Godfather",
    "duration": "PT175M",
    "actors": [ "Marlon Brando", "Al Pacino", "James Caan" ],
    "ratings": [],
    "favorites": [15291, 51417, 7001, 9250, 71389, 93707],
    "watchlist": [62289, 66380, 34139, 6146]
  },
  {
    "title": "The Dark Knight",
    "duration": "PT152M",
    "actors": [ "Christian Bale", "Heath Ledger", "Aaron Eckhart" ],
    "ratings": [],
    "favorites": [15291, 7001, 9250, 34139, 93707],
    "watchlist": [51417, 62289, 6146, 71389]
  },
  {
    "title": "Pulp Fiction",
    "duration": "PT154M",
    "actors": [ "John Travolta", "Uma Thurman", "Samuel L. Jackson" ],
    "ratings": [],
    "favorites": [15291, 51417, 62289, 66380, 71389, 93707],
    "watchlist": [7001, 9250, 34139, 6146]
  }
```

### Users collection

    {
        "userId": 15291,
        "email": "Constantin_Kuhlman15@yahoo.com",
        "friends": [7001, 51417, 62289]
    },
    {
        "userId": 7001,
        "email": "Keven6@gmail.com",
        "friends": [15291, 51417, 62289, 66380]
    },
    {
        "userId": 51417,
        "email": "Margaretta82@gmail.com",
        "friends": [15291, 7001, 9250]
    },
    {
        "userId": 62289,
        "email": "Marquise.Borer@hotmail.com",
        "friends": [15291, 7001]
    }

```

## Example output

Your implementation should return following output for **userId=62289** for example data:

```json
["The Dark Knight", "The Godfather", "Pulp Fiction"]
```

In the example above, user with id `62289` has two friends: user with `id=15291` and with `id=7001`. `The Dark Knight` and `The Godfather` movies are favorited by both users, so it will be the most favorited. `"Pulp Fiction"` and `"The Shawshank Redemption"` are favorited by one of the users, but the Pulp Fiction starts with `P` and will get into top 3 movies, instead of `"The Shawshank Redemption"`
