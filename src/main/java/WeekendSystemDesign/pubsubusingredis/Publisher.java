package WeekendSystemDesign.pubsubusingredis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Publisher
{
    private final Jedis publisherJedis ;
    private final String channel_name;
  
    public Publisher(Jedis publisherJedis, String channel)
    {
           this.publisherJedis = publisherJedis;
            this.channel_name = channel;
    }
    public void publish()
    {
        System.out.println("Type your message....exit for terminate");
        try
      {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
             while (true)
             {
                  String line = reader.readLine();
                  if (!"exit".equals(line)) {
                     publisherJedis.publish(channel_name, line);
                    }
            else {
                            break;
                      }
                }
        }
    catch (IOException e) {
                System.out.println("IO failure while reading input, e");
        }
    }

    public static void main(String[] args) {

        JedisPool jedispool = new JedisPool("localhost");
        Jedis publisherJedis = jedispool.getResource();
        Publisher publisher = new Publisher(publisherJedis,"redisChannel");
        publisher.publish();
        // new Publisher(publisherJedis,channel_name).publish();

    }
}