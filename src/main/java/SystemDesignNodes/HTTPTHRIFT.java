package SystemDesignNodes;

/**
 * Created by hadoop on 26/1/18.
 */
public class HTTPTHRIFT {
}

/*


11/6/14


HTTP just provides
a byte stream that you can read off
of, so I would assume that what
 TServlet is doing is serializing thrift messages,
  shoving them into HTTP Request bodies,
  and then sending them over the wire.
  Probably finagle's scrooge, thrift helpers,
   etc will not be terribly useful unless
    you want to use our serialization/deserialization implementations.

 */