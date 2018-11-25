package WeekendSystemDesign;

/**
 * Created by hadoop on 9/3/18.
 */
public class MysqlMasterSlaveReplication {

}

/*
Replicate AT mysql level from master to slaves :-
// so that read and write traffic gets distributed
// master can look into writes
// slaves can handle all of the reades
https://www.youtube.com/watch?v=dkhOZOmV7Fo


We can have master-slaves architecture and decide the consistenncy as in how
many slaves would write before i tell to end user that write is succesful


 */

/*
If we wants to handles writes , we would look into sharding techinqueue based of consistent
hashing and see how things work

And each shared dataset would have again master -slave architecctures so that we have backup
incase master goes down

 */
