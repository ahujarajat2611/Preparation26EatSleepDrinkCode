package WeekendSystemDesign;

/**
 * Created by hadoop on 10/3/18.
 */
public class DesignInstagram {
}
/*
1)instagram service
Any regions,
1 million DAU
500 total users


1000,000 * 50  / 24* 60 * 60 * 20  =

1)postPictures ( Image image, UserAccount userAccount);
2)getTimeLine(User userId)


1)postPictures ( Image image, UserAccount userAccount)

1000,000 * 5 * 100  /(1000,000) ~  500 users trying to post pic per second

Space :- 1 Mb * 1000,000 = 1 Tb space daily space

2) ViewPicure(picturedid ) -> cache

2) Get Time
500 * 20 ~ 10k request per second
userdevice -> (Https) ->;Load Balancerd(Server) -> (postPic()) -> Database Also (Distributed Cache )
postPic() -> generate Unique Id of each Picture ->

64 bits - 48
Mysql Database SHarding ( ) -> To generate Unique :- (TimeStamp + ServerId + UserId) -> ( UUID) 128 bits
Schema Database
( Master )                              ||  Slaves
userId, picture id(Pk), Timestamp, url |||  userId, pictureId(pK), Timstamep, url (location in my distributed system)

at WAL -> HDFS

Zooeekper ( Shard based )
Followers Table
UserId, Userid


Distributed STorage
pictureId :-> picture bytes ( .jpg)
userDEvice -> https request -> LoadBalancer->List<pictureId> getTimeLine(userId)->
xyz % 10 = 2 ->

a)Redis)-:UserID-> List<PicctureId>


a) design google doc
b) desig n twitter
c) facebook search
d) google search
e) whatsapp
f) highly available system
g ) highly consistent databae
) distributed key value store
  netflix
  youtube
  collabedit
 */
