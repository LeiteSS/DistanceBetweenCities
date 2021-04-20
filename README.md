# Distance Between Cities

Using this [repo](https://github.com/chinnonsantos/sql-paises-estados-cidades) with all countries, Brazilian states, and Brazilian cities, it was developed an API to calculate the distance between the cities.

## Dependencies 

**Hibernate-types**: This dependence brings the Json Type class to use when it is necessary to tell to hibernate what a Json type is. 

```groovy
implementation 'com.vladmihalcea:hibernate-types-52:2.9.8'
```

**PostgreSQL**: This dependence is necessary when it had coordinates' points. It is possible to show coordinates' points saved in database use the String type, but it is necessary to deal with it to convert to Integer. The **PostgreSQL**'s dependence had the **PGPoint** and organize the coordinates' points saved in database in variables called `x` and `y`; in JSON format too.  

```groovy
implementation 'org.postgresql:postgresql'
```

## In The Air

Click here to "play" with the API or copy and paste this link: `https://young-waters-87085.herokuapp.com` in **Postman**. The requests are those:

```bash
# Countries
GET: https://young-waters-87085.herokuapp.com/countries
GET: https://young-waters-87085.herokuapp.com/countries?page=0&size=10&sort=name,asc

# States
GET: https://young-waters-87085.herokuapp.com/states

# Cities
GET: https://young-waters-87085.herokuapp.com/cities

# Distance
GET: https://young-waters-87085.herokuapp.com/distance/by-points?from=4929&to=5254
GET: https://young-waters-87085.herokuapp.com/distance/by-cube?from=4929&to=5254
GET: https://young-waters-87085.herokuapp.com/distance/by-math?from=4929&to=5254&unit=MILES
```

