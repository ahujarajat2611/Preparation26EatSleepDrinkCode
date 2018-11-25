package SystemDesignNotes1;

/**
 * Created by hadoop on 8/3/18.
 */
public class LSMTrees {

}
/*
https://www.quora.com/How-does-the-Log-Structured-Merge-Tree-work
 */
/*
Thanks for A2A. I will try my best to explain the working of Log Structure Merge (LSM) tree in a language that I understand it. The technical details can be found at the paper at the link provided at the bottom.

    Starting with a use case that would make
     it simpler for us to understand.
     Let's take the most common bank account database system.
     Here as we already know, the major actions are deposit,
      withdraw and a bank generally maintains whole log of customer activity
       and later publishes it through Bank Account Statement when requested
       by the user.
    In the above example, in general scenario,
    the frequency of transactions such as deposit and withdraw
    is significantly higher than a customer
     requesting for a bank account statement. What this means from
     Database perspective is that the actions of insert and delete
      into the database are happening much more frequently
      than a scan or select operation. Also,
      the database becomes humongous in size as the operations of the bank grow.
       This causes major performance issues with insert and delete
       scenario that we are interested in.


   To address the major performance concern in above case,
    the first most intuitive or rather primitive way is to have
     the data structure that stores the bank information in the memory
     but this is not possible due to the huge size of data involved.
      Also, to address the concern about huge size,
       if we store the data on the disks, it will hamper performance
       while doing insert and delete due to large number of disk I/Os.
        Thus this is the case of trade-off in handling performance and
         size of the data.
    To address the above mentioned issues,
     let's understand what the LSM tree provides.
     The basic form of LSM tree is a two-level tree with level C0 and C1.
      These levels are nothing but the components of the tree where C0
      is always present in the memory i.e. memory resident and
      C1 is always present on the disk i.e. disk resident.
       On a high level, whenever a request comes to insert any information
        to the database, entry is made into C0 level which is pretty quick
         as it is present in the memory.
         The entries made into C0 level and subsequently transferred to
         C1 level present on disk to address the size concern.
          The transfer of data from C0 to C1 happens through the process of
          rolling merge which is more or less similar to merge sort.


    The C0 level tree is generally an AVL tree (a tree that balances itself)
     and we aren't generally concerned about the size of its nodes
     to be in sync with page size of disk simply because it's not present
     on the disk!
      Though one might get tempted to have a huge C0 level tree for
       high performance, there are constraints due to the memory.
       Thus, there is threshold for the data it can hold beyond which the
       older entries from C0 are moved to C1 level thus keeping the size of C0 in check.
    The C1 level tree generally resembles a B-tree.
     It is optimized for sequential disk access. The structure
     mainly comprises sequences of single-page nodes on each level
      below the root packed together in contiguous multi-page disk blocks.
      The nodes are 100% full.
    While the data gets transferred from C0 to C1 level,
    technique of rolling merge is used.
    Rolling merge happens in a series of steps.
     Every step involves merging of disk page sized leaf nodes
     from C1 level with leaf level entries from C0 level
      forming a newly merged leaf node of C1 tree.
       The newly merged leaf node is generally stored on a
        new disk space to facilitate recovery of old leaf node
        in case of a crash.
        The following diagram (source: the paper link at the bottom.) gives a fair sense of what happens in case of rolling merge.


As you can see, the circled part from C1 tree is taken,
circled part from C0 is merged with it and finally allocated
new disk space in C1 tree.

This is how on high level a two level LSM tree works.
There can be multiple levels but level 0 is always kept in the memory,
 reresented as a tree, to enhance the performance.
 The on-disk level is organized to suit the particular
  need of the project where LSM tree is used. It can be sorted runs of data where each run contains data sorted on index key.

To keep it clear and simple enough, I have got rid of core technical details wherever possible. If you are interested in thorough information about LSM tree, you can always read up the research paper on Log Structured Merge Tree found at http://paperhub.s3.amazonaws.com... from where I have taken almost all of the information about it.
 */

/*

a)4 data centrs :- each data centre running 1000 of machines - applications
b)configuration system ;- user can change config consitentnly
c)

500 key value pairs on the fly !!!
App should get that value
1)
2phase commit !!!
3)Alarm system ( host is not able to talk to User)
4)versioning


a)Database :- 1
b)Log system :- 2
c)Zookeeper :-
d)Versioning System
e)Read :-Forulate things ( ) :-
  ReDoing things
  on a peice of paper

a)Drive the discussions
b)Do you need that why !!
c)Zookeeper( distributed System)
d)Master DC went down !
e)Failover goes down ( Continues to work if master goes down)
f)Host

 */