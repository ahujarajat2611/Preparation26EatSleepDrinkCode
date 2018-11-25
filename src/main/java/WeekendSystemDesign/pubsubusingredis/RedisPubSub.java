/*
http://www.oodlestechnologies.com/blogs/Implement-Redis-Publish_Subscribe-messaging-paradigm

 */
package WeekendSystemDesign.pubsubusingredis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
public class RedisPubSub
{
    public static final String channel_name= "redisChannel";
     
    public static void main(String[] args) throws Exception
    {      
        JedisPool jedispool = new JedisPool("localhost");
        final Jedis subscriberJedis = jedispool.getResource();
        final Subscriber subscriber = new Subscriber();
        System.out.println("block");
        subscriberJedis.subscribe(subscriber,channel_name);
        System.out.println("block");
//        new Thread(new Runnable(){
//            public void run()
//            {
//
//                try
//                {
//                    System.out.println("Subscribing to " +channel_name);
//                    subscriberJedis.subscribe(subscriber,channel_name);
//                    System.out.println("Subscription ended.");
//                }
//                catch (Exception e)
//                {
//                    System.out.println("Subscribing failed."+e);
//                }
//            }
//        }).start();
//
//
//        Jedis publisherJedis = jedispool.getResource();
//        System.out.println("end of thiis 1");
//       // new Publisher(publisherJedis,channel_name).publish();
//        System.out.println("end of this 2");
////        subscriber.unsubscribe();
//        System.out.println("end of thiis 3");
//        //jedispool.returnResource(subscriberJedis);
//        System.out.println("end of thiis 4");
//
//      //  jedispool.returnResource(publisherJedis);
//        System.out.println("end of thiis 5");
//
//        System.out.println("end of thiis");
    }
}