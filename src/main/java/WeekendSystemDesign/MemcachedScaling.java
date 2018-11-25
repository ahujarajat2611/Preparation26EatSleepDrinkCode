package WeekendSystemDesign;

/**
 * Created by hadoop on 9/3/18.
 */
public class MemcachedScaling {
}
/*
https://www.youtube.com/watch?v=6phA3IAcEJ8&t=67s
 */
/*
1) Near real time communication
2) Aggregate content on the fly
3) Updates of OBama
4) MIllions of users per second


Very heay read load
1 billion reads per seconds
store trillions of items in cache

Memached
Basic building block for distributed key-value store for face book
Network attached in memory hashtable
Concepts aint limited to memached
Trillion of items in memcahce



1) Read we hit cache if not present look into database and update cahce for next request
2) Updates :- write directly to database ( Here cache is not comming into picture  )
// we arr direcctly writing into database and then deleting that entry into cache so that
// cache and database are consiistensts


Problems with cache staleness

Items in cache are distruibuted through CH meaning u take key
find Consistent hash and put look for that server






 */