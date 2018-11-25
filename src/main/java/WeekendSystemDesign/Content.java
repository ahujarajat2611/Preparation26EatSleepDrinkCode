package WeekendSystemDesign;

/**
 * Created by hadoop on 10/3/18.
 */
public class Content {
}
/*
Here is the original post address: http://www.mitbbs.com/article_t/JobHunting/32492515.html

The following is reproduced content

=========================== I am split line ==================

A little summarize

1. The entry-level Feed News
http://www.quora.com/What-are-best-practices-for-building-somet
http://www.infoq.com/presentations/Scale-at-Facebook
http://www.infoq.com/presentations/Facebook-Software-Stack
general followup question is to estimate how much server requires
additional discussion of this post
http://www.mitbbs.ca/article_t/JobHunting/32463885.html
this The article mentions a bit how to approach such questions, you can take a look at
http://book.douban.com/reading/23757677/


2. facebook chat, which is also often asked
http://www.erlang-factory .com/upload/presentations/31/EugeneLet
https://www.facebook.com/note.php?note_id=14218138919
http://www.cnblogs.com/piaoger/archive/2012/08/19/2646530.html
http://essay.utwente.nl/59204/1/scriptie_J_Schipers.pdf

3. typeahead search/search suggestion, this is also common
https://www.facebook.com/video/video.php?v=432864835468 The
question is discussed in this post, basically every question has in the video Answer
http://www.mitbbs.com/article_t/JobHunting/32438927.html


4. Facebook Messaging System (the mention of inbox search, which has been asked before)
messaging system is a to all chat/sms/email like a system that combines both
http://www.infoq.com/presentations/HBase-at-Facebook
http://sites.computer.org/debull/A12june/facebook.pdf
http://www.slideshare.net/ Brizzzdotcom/facebook-messages-hbase/
https://www.youtube.com/watch?v=UaGINWPK068


5. For a cell phone location signal (latitude and longitude), you need to return to a nearby 5mile POI.
This is discussed here. nyc love test ...
http://www.mitbbs.ca/article0/JobHunting/32476139_0.html


6. Implement SECOND, / minute / hour / Day counters
This question really do not think it is a system design, but if asked, or have prepared, seemingly was asked in an interview will be the headquarters of
road ....
This post has discussed
http://www.mitbbs.com/article_t/JobHunting/ 32458451.html


7. facebook photo storage, this will not be asked, but it is also good to know
https://www.usenix.org/legacy/event/osdi10/tech/full_papers/Beaver.pdf
https://www. Facebook.com/note.php?note_id=76191543919


8. Facebook timeline, this is not a question, check it out on the line
https://www.facebook.com/note.php?note_id=10150468255628920
http://highscalability. Com/blog/2012/1/23/facebook-timeline-bro


In addition to these, prepare these questions
implement memcache
http://www.adayinthelifeof.nl/2011/02/06/memcache-internals/implement

tinyurl (and distribute across Multiple servers)
http://stackoverflow.com/questions/742013/how-to-code-a-url-sho

Trending Topics the Determine (twitter)
http://www.americanscientist.org/issues/pub/the-britney-spears-
http://www.michael-noll.com/blog/2013/01/18/implementing-real- t

copy one file to multiple servers
http://vimeo.com/11280885

Slightly know dynamo key value store, and google gfs and big table


also recommend some sites
http://highscalability.com/blog/category/facebook
this high There are a lot of things about the system design in the scalability. Not only facebook, but no time
, just look at the interview you want.
facebook engineering blog
http://www.quora.com/Facebook-Engineering /What-is-Facebooks-arc
http://stackoverflow.com/questions/3533948/facebook-architectur

Other Home
http://www.quora.com/What-are-the-top-startup-engineering-blogs


================================================== ================
in an interview to talk about how to prepare this
first if you can not even availability / scalability / consistency / partition and the like are not too shall
read it, I recommend to go wikipedia a university or find a website talking about this course a little look, not a
point is not aware of
this link is also good
http://www.aosabook.org/en/distsys.html

If you still have these basic things know, then I think you and most people have no practical experience of almost a
horizontal ...
can do is to prepare for a little bit, if you have enough time, I suggest you interview from the house The company’s
engineering blog looks at the technology stack/product of the home and makes it clear. Then we can
do all the interview questions we can find.... If you are firm
hold imagine what will happen will really see the experience, you will find a lot of places have in common, you can see more photos gourd painting
scoop ...

then there is the interview should be how to approach this Questions I talk about my practice
1. product spec / usage scenario and the interviewer confirm this thing in the end is what to do
can be the first to list a few major functionality, then you have time, add some unimportant
you think write Down

2. Define some major components
is to draw a few circle frames, each to express some of your opinions .... and then say how the interaction between them

above is the question specific thing,
this is finished, we can talk about some The questions are used, such as
how to scale / how to achieve partition / how to achieve consistency, these things can be applied to any question, of



course, the problems we encountered and the method of solving problems may be different, not necessarily every way there is a problem down the large ones,
most importantly, when to be methodical topic, drawing to clear, maintain and exchange interviewer, at any time ask the person
views the house.

There are so many things that I can think of. Welcome everyone to communicate. I hope everyone can find the ideal job.


 */